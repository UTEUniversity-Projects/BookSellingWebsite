package com.biblio.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class UploadFileUtil {

    private static final String UPLOAD_DIR = "images";

    public static String UploadImage(Part filePart, ServletContext servletContext) {
        if (filePart == null || filePart.getSize() == 0) {
            throw new IllegalArgumentException("File is not allow empty !");
        }

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String absolutePath = servletContext.getRealPath("") + UPLOAD_DIR;
        Path uploadPath = Paths.get(absolutePath);
        
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException("Error while creating upload directory!\n" + e.getMessage());
            }
        }

        Path filePath = uploadPath.resolve(fileName);

        try (InputStream inputStream = filePart.getInputStream()) {
            Files.copy(inputStream, filePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error while uploading image !\n" + e.getMessage());
        }

        return servletContext.getContextPath() + "/" + UPLOAD_DIR + "/" + fileName;
    }
}
