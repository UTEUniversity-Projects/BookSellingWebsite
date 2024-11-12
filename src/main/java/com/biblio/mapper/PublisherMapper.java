package com.biblio.mapper;

import com.biblio.dto.response.PublisherResponse;
import com.biblio.entity.Publisher;

public class PublisherMapper {
    public static PublisherResponse toPublisherResponse(Publisher publisher) {
        PublisherResponse response = new PublisherResponse();
        response.setName(publisher.getName());

        return response;
    }
}
