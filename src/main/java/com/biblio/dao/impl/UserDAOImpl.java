package com.biblio.dao.impl;

import com.biblio.dao.IUserDAO;
import com.biblio.entity.SiteContent;

import java.util.UUID;

public class UserDAOImpl extends GenericDAOImpl<SiteContent, UUID> implements IUserDAO {

    public UserDAOImpl() {
        super(SiteContent.class);
    }

    public void add() {
        SiteContent siteContent = new SiteContent();
        siteContent.setTitle("123");
        siteContent.setContent("123");
        siteContent.setEffective(true);
        super.save(siteContent);
    }

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.add();
    }
}
