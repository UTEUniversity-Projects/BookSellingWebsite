package com.biblio.service;

import com.biblio.dto.response.AccountGetResponse;

public interface IAccountService {

    boolean isUsernameExist(String username);
    AccountGetResponse getAccountByUsername(String username);

}
