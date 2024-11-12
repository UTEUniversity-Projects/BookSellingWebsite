package com.biblio.mapper;

import com.biblio.dto.response.AccountGetResponse;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.entity.Account;
import com.biblio.entity.Address;
import com.biblio.entity.Customer;

public class AccountMapper {
    public static AccountGetResponse toAccountGetResponse(Account account) {
        AccountGetResponse accountGetResponse = new AccountGetResponse();
        accountGetResponse.setUsername(account.getUsername());
        accountGetResponse.setPassword(account.getPassword());
        accountGetResponse.setStatus(account.getStatus().toString());
        accountGetResponse.setRole(account.getUserRole().toString());
        return accountGetResponse;
    }
}
