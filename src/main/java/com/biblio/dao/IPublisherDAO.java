package com.biblio.dao;

import com.biblio.entity.Publisher;

import java.util.List;

public interface IPublisherDAO {
    List<Publisher> findAll();
    Publisher findById(Long id);
    void addPublisher(Publisher publisher);
    void updatePublisher(Publisher publisher);
    void deletePublisher(Long id);
}
