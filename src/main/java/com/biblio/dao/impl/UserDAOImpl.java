package com.biblio.dao.staff.impl;

import com.biblio.dao.GenericDAOImpl;
import com.biblio.entity.User;
import com.biblio.dao.staff.IUserDAO;

import java.util.UUID;

public class UserDAOImpl extends GenericDAOImpl<User, UUID> implements IUserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

}
