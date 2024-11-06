package com.biblio.dao.owner.impl;

import com.biblio.dao.GenericDAOImpl;
import com.biblio.entity.User;
import com.biblio.dao.owner.IUserDAO;

import java.util.UUID;

public class UserDAOImpl extends GenericDAOImpl<User, UUID> implements IUserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

}
