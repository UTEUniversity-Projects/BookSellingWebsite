package com.biblio.dao.impl;

import com.biblio.dao.IAuthorDAO;
import com.biblio.entity.Author;

import java.util.List;

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
