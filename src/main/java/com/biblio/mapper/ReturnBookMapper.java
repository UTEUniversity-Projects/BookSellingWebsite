package com.biblio.mapper;

import com.biblio.dto.response.ReturnBookItemResponse;
import com.biblio.dto.response.ReturnBookManagementResponse;
import com.biblio.entity.MediaFile;
import com.biblio.entity.ReturnBook;
import com.biblio.entity.ReturnBookItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.biblio.utils.DateTimeUtil.formatDateTime;

public class ReturnBookMapper {
    public static ReturnBookManagementResponse toReturnBookManagementResponse(ReturnBook returnBook) {

        List<String> fileNames = returnBook.getProof().stream()
                .sorted(Comparator.comparing(MediaFile::getId))
                .map(MediaFile::getStoredCode)
                .toList();

        List<ReturnBookItemResponse> items = new ArrayList<>();
        for (ReturnBookItem item : returnBook.getReturnBookItems()) {
            items.add(ReturnBookItemMapper.toReturnBookItemResponse(item));
        }

        return ReturnBookManagementResponse.builder()
                .id(returnBook.getId())
                .items(items)
                .reason(returnBook.getReason())
                .description(returnBook.getDescription())
                .createdAt(formatDateTime(returnBook.getCreatedAt(), "HH:mm dd-MM-yyyy"))
                .proof(fileNames)
                .build();
    }
}
