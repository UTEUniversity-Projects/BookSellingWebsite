package com.biblio.dao.customer.impl;

import com.biblio.dao.GenericDAOImpl;
import com.biblio.dao.customer.IUserDAO;
import com.biblio.entity.User;

import java.util.UUID;

public class UserDAOImpl extends GenericDAOImpl<User, UUID> implements IUserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

}
