package com.biblio.mapper;

import com.biblio.dto.request.PublisherRequest;
import com.biblio.dto.response.PublisherResponse;
import com.biblio.entity.Publisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PublisherMapper {
    public static Publisher toPublisherEntity(PublisherRequest publisherRequest) {
        return Publisher.builder()
                .id(Long.parseLong(publisherRequest.getId()))
                .name(publisherRequest.getName())
                .avatar(publisherRequest.getAvatar())
                .introduction(publisherRequest.getIntroduction())
                .joinAt(LocalDateTime.parse(publisherRequest.getJoinAt()))
                .build();
    }

    public static PublisherResponse toPublisherResponse(Publisher publisher) {
        return PublisherResponse.builder()
                .id(publisher.getId().toString())
                .name(publisher.getName())
                .avatar(publisher.getAvatar())
                .introduction(publisher.getIntroduction())
                .joinAt(publisher.getJoinAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
    }
}
