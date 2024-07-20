package com.eoi.grupo5.servicios.archivos;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFilesService {

    String handleFileUpload(MultipartFile file) throws Exception;

}
