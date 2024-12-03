package com.biblio.dao.impl;

import com.biblio.dao.IBookMetadataDAO;
import com.biblio.entity.BookMetadata;

import java.util.HashMap;
import java.util.Map;

public class BookMetadataDAOImpl extends GenericDAOImpl<BookMetadata> implements IBookMetadataDAO {
    public BookMetadataDAOImpl() {
        super(BookMetadata.class);
    }

    @Override
    public BookMetadata createBookMetadata(BookMetadata bookMetadata) {
        return super.save(bookMetadata);
    }

    @Override
    public void deleteBookMetadata(Long id) {
        String sql = "DELETE FROM book_metadata " +
                "WHERE id = :bookMetadataId";

        Map<String, Object> params = new HashMap<>();
        params.put("bookMetadataId", id);

        super.executeNativeQuery(sql, params);
    }
}
