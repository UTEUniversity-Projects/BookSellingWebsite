package com.biblio.service.impl;

import com.biblio.dao.IPublisherDAO;
import com.biblio.dto.request.PublisherRequest;
import com.biblio.dto.response.PublisherResponse;
import com.biblio.entity.Publisher;
import com.biblio.mapper.PublisherMapper;
import com.biblio.service.IPublisherService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class PublisherServiceImpl implements IPublisherService {
    @Inject
    IPublisherDAO publisherDAO;

    @Override
    public List<PublisherResponse> findAll() {
        List<PublisherResponse> list = new ArrayList<PublisherResponse>();
        for (Publisher publisher : publisherDAO.findAll()) {
            list.add(PublisherMapper.toPublisherResponse(publisher));
        }
        return list;
    }

    @Override
    public PublisherResponse findById(Long id) {
        return PublisherMapper.toPublisherResponse(publisherDAO.findById(id));
    }

    @Override
    public void addPublisher(PublisherRequest publisherRequest) {
        publisherDAO.addPublisher(PublisherMapper.toPublisherEntity(publisherRequest));
    }

    @Override
    public void updatePublisher(PublisherRequest publisherRequest) {
        publisherDAO.updatePublisher(PublisherMapper.toPublisherEntity(publisherRequest));
    }

    @Override
    public void deletePublisher(Long id) {
        publisherDAO.deletePublisher(id);
    }
}
