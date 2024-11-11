package com.biblio.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFileUtil {

    private static final String UPLOAD_DIR = "images";

    public static String UploadImage(Part filePart, ServletContext servletContext, String username) {
        if (filePart == null || filePart.getSize() == 0) {
            throw new IllegalArgumentException("File is not allowed to be empty!");
        }

        // Lấy phần mở rộng của tệp gốc
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileExtension = "";
        int i = originalFileName.lastIndexOf('.');
        if (i > 0) {
            fileExtension = originalFileName.substring(i);
        }

        // Tạo tên tệp mới từ username và giữ nguyên phần mở rộng
        String newFileName = username + fileExtension;

        String absolutePath = servletContext.getRealPath("") + UPLOAD_DIR;
        Path uploadPath = Paths.get(absolutePath);

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException("Error while creating upload directory!\n" + e.getMessage());
            }
        }

        Path filePath = uploadPath.resolve(newFileName);

        try (InputStream inputStream = filePart.getInputStream()) {
            Files.copy(inputStream, filePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error while uploading image!\n" + e.getMessage());
        }

        return servletContext.getContextPath() + "/" + UPLOAD_DIR + "/" + newFileName;
    }
}

