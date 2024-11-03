package com.biblio.dao.impl;

import com.biblio.dao.IUserDAO;
import com.biblio.entity.User;

import java.util.UUID;

public class UserDAOImpl extends GenericDAOImpl<User, UUID> implements IUserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

}
