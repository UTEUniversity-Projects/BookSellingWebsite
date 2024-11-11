package com.biblio.dao.impl;

import com.biblio.dao.IAccountDAO;
import com.biblio.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountDAOImpl extends GenericDAOImpl<Account> implements IAccountDAO {
    public AccountDAOImpl() {
        super(Account.class);
    }

    @Override
    public boolean isUsernameExist(String username) {
        String jpql = "SELECT a FROM Account a WHERE a.username = :username";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        return super.findSingleByJPQL(jpql, params) != null;
    }

}
