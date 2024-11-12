package com.biblio.mapper;

import com.biblio.dto.response.BookMetadataResponse;
import com.biblio.dto.response.MediaFileResponse;
import com.biblio.entity.BookMetadata;
import com.biblio.entity.MediaFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookMetadataMapper {
    public static BookMetadataResponse toBookMetadataResponse(BookMetadata bookMetadata) {
        BookMetadataResponse bookMetadataResponse = new BookMetadataResponse();

        List<MediaFile> mediaFiles = new ArrayList<>(bookMetadata.getMediaFiles());

        mediaFiles.sort(Comparator.comparing(MediaFile::getFileName));

        for (MediaFile mediaFile : mediaFiles) {
            System.out.println("MediaFile: " + mediaFile.getFileName());
            bookMetadataResponse.getMediaFiles().add(MediaFileMapper.toMediaFileResponse(mediaFile));
        }

        return bookMetadataResponse;
    }
}
