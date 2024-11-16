package com.biblio.dao.impl;

import com.biblio.dao.IPublisherDAO;
import com.biblio.entity.Publisher;

import java.util.List;

public class PublisherDAOImpl extends GenericDAOImpl<Publisher> implements IPublisherDAO {
    
    public PublisherDAOImpl() {
        super(Publisher.class);
    }

    @Override
    public List<Publisher> findAll() {
        return super.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void addPublisher(Publisher publisher) {
        super.save(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        super.update(publisher);
    }

    @Override
    public void deletePublisher(Long id) {
        super.delete(id);
    }
}
