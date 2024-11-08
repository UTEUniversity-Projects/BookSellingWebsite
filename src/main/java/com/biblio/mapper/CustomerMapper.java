package com.biblio.mapper;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerGetListResponse;
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
    public static CustomerGetListResponse toCustomerGetListResponse(Customer customer) {
        CustomerGetListResponse customerGetListResponse = new CustomerGetListResponse();
        customerGetListResponse.setId(customer.getId());
        customerGetListResponse.setAvatar(customer.getAvatar());
        customerGetListResponse.setDateOfBirth(customer.getDateOfBirth());
        customerGetListResponse.setEmail(customer.getEmailAddress());
        customerGetListResponse.setFullName(customer.getFullName());
        customerGetListResponse.setGender(customer.getGender().toString());
        customerGetListResponse.setJoinAt(customer.getJoinAt().toString());
        customerGetListResponse.setPhoneNumber(customer.getPhoneNumber());
        customerGetListResponse.setMemberShip(customer.getMembership().toString());

        customerGetListResponse.setUsername(customer.getAccount().getUsername());
        customerGetListResponse.setPassword(customer.getAccount().getPassword());

        for (Address address : customer.getAddresses()) {
            customerGetListResponse.getAddresses().add(AddressMapper.toAddressResponse(address));
        }

        return customerGetListResponse;
    }

}
