package com.eoi.grupo5.servicios.archivos;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class IUploadFilesImpl implements IUploadFilesService {


    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {

        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if(fileSize > maxFileSize) {
                return "El tamaño del archivo debe ser inferior o igual a 5MB";
            }

            if(
                    !fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".png")
            ) {
                return "Solo archivos JPG, JPEG, PNG están permitidos!";
            }

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;

            File folder = new File("src/main/resources/images");
            if(!folder.exists()) {
                folder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/images/" + newFileName);
            Files.write(path, bytes);
            return "Subida de Archivo satisfactoria!";

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
