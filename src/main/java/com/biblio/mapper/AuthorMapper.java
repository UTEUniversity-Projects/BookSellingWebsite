package com.biblio.mapper;

import com.biblio.dto.response.AuthorResponse;
import com.biblio.entity.Author;

public class AuthorMapper {
    public static AuthorResponse toAuthorResponse(Author author) {
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setName(author.getName());
        authorResponse.setIntroduction(author.getIntroduction());
        authorResponse.setAvatar(author.getAvatar());

        return authorResponse;
    }
}
