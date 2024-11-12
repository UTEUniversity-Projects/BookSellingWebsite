package com.biblio.service;

import com.biblio.dto.request.PublisherRequest;
import com.biblio.dto.response.PublisherResponse;

import java.util.List;

public interface IPublisherService {
    List<PublisherResponse> findAll();
    PublisherResponse findById(Long id);
    void addPublisher(PublisherRequest publisherRequest);
    void updatePublisher(PublisherRequest publisherRequest);
    void deletePublisher(Long id);
}
