package com.biblio.service;

import com.biblio.dto.request.PublisherCreateRequest;
import com.biblio.dto.request.PublisherDeleteRequest;
import com.biblio.dto.request.PublisherUpdateRequest;
import com.biblio.dto.response.PublisherAnalysisResponse;
import com.biblio.dto.response.PublisherLineResponse;
import com.biblio.dto.response.PublisherProfileResponse;
import com.biblio.entity.Publisher;

import java.util.List;

public interface IPublisherService {
    List<PublisherLineResponse> getAll();
    PublisherProfileResponse getProfileById(Long id);
    PublisherAnalysisResponse getAnalysisById(Long id);
    Publisher create(PublisherCreateRequest publisherRequest);
    void update(PublisherUpdateRequest publisherRequest);
    void delete(PublisherDeleteRequest publisherDeleteRequest);
    Integer countBookTemplate(PublisherDeleteRequest id);
}
