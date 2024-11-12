package com.biblio.dao;

import com.biblio.entity.Account;

public interface IAccountDAO {

    boolean isUsernameExist(String username);
    Account getAccountByUsername(String username);
}
