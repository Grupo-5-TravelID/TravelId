package com.eoi.grupo5.controladores;

import com.eoi.grupo5.servicios.archivos.IUploadFilesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {

    IUploadFilesService uploadFilesService;

    public UploadFilesController(IUploadFilesService uploadFilesService) {
        this.uploadFilesService = uploadFilesService;
    }

    @PostMapping("/image")
    private ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(uploadFilesService.handleFileUpload(file), HttpStatus.OK);
    }

}
