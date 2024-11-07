package com.biblio.mapper;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.entity.Account;
import com.biblio.entity.Address;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EUserRole;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerMapper {
    public static Customer toCustomerRegister(CustomerRegisterRequest customerRegisterRequest) {
        Customer customer = new Customer();
        customer.setFullName(customerRegisterRequest.getFullName());
        customer.setEmailAddress(customerRegisterRequest.getEmail());
        customer.setPhoneNumber(customerRegisterRequest.getPhoneNumber());
        customer.setDateOfBirth(customerRegisterRequest.getDateOfBirth());
        customer.setGender(EGender.valueOf(customerRegisterRequest.getGender()));
        Account account = new Account();
        account.setUsername(customerRegisterRequest.getUsername());
        account.setPassword(customerRegisterRequest.getPassword());
        account.setUserRole(EUserRole.CUSTOMER);
        account.setStatus(EAccountStatus.ACTIVE);
        account.setCustomer(customer);
        customer.setAccount(account);
        Address address = new Address();
        address.setNation("Việt Nam");
        address.setProvince(customerRegisterRequest.getCity());
        address.setDistrict(customerRegisterRequest.getDistrict());
        address.setVillage(customerRegisterRequest.getHamlet());
        customer.setAddresses(Set.of(address));
        address.setCustomer(customer);
        customer.setAvatar(customerRegisterRequest.getAvatar());
        customer.setJoinAt(LocalDateTime.now());
        return customer;
    }
}
