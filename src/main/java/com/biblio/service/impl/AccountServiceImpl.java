package com.biblio.service.impl;

import com.biblio.dao.IAccountDAO;
import com.biblio.service.IAccountService;

import javax.inject.Inject;

public class AccountServiceImpl implements IAccountService {

    @Inject
    private IAccountDAO accountDAO;

    @Override
    public boolean isUsernameExist(String username) {
        return accountDAO.isUsernameExist(username);
    }
}
