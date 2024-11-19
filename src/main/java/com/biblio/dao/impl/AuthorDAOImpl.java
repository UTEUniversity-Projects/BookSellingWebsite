package com.biblio.dao.impl;

import com.biblio.dao.IAuthorDAO;
import com.biblio.entity.Author;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDAOImpl extends GenericDAOImpl<Author> implements IAuthorDAO {

    public AuthorDAOImpl() {
        super(Author.class);
    }

    @Override
    public List<Author> findAll() {
        return super.findAll();
    }

    @Override
    public Author findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Author> findByBookTemplate(BookTemplate bookTemplate) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT DISTINCT a ")
                .append("FROM Author a ")
                .append("JOIN a.bookTemplates bt ")
                .append("WHERE bt = :bookTemplate");

        Map<String, Object> params = new HashMap<>();
        params.put("bookTemplate", bookTemplate);
        return super.findByJPQL(jpql.toString(), params);
    }

    @Override
    public void addAuthor(Author author) {
        super.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        super.update(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        System.out.println(id);
        super.delete(id);
    }

    public static void main(String[] args){
        AuthorDAOImpl dao = new AuthorDAOImpl();
        List<Author> list = dao.findAll();
        for (Author author : list){
            System.out.println(author.getName());
        }
    }

}
