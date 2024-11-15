package com.biblio.mapper;

import com.biblio.dto.request.AuthorRequest;
import com.biblio.dto.response.AuthorResponse;
import com.biblio.entity.Author;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthorMapper {

    public static Author toAuthorEntity(AuthorRequest authorRequest) {
        return Author.builder()
                .id(Long.parseLong(authorRequest.getId()))
                .name(authorRequest.getName())
                .avatar(authorRequest.getAvatar())
                .introduction(authorRequest.getIntroduction())
                .joinAt(LocalDateTime.parse(authorRequest.getJoinAt()))
                .build();
    }

    public static AuthorResponse toAuthorResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .avatar(author.getAvatar())
                .introduction(author.getIntroduction())
                .joinAt(author.getJoinAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
    }
    
}
