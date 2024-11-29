package com.biblio.utils;

import com.biblio.constants.StoredFileConstants;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ManageFileUtil {

    public static Boolean deleteAuthorAvatar(ServletContext servletContext, String filePath) {
        try {
            if (Objects.equals(filePath, StoredFileConstants.AUTHOR_DEFAULT_AVA)) {
                return true;
            }

            filePath = filePath.replace("/", "\\");
            filePath = StoredFileConstants.LOCAL_STORED + filePath;

            Path path = Paths.get(filePath);
            return Files.deleteIfExists(path);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
