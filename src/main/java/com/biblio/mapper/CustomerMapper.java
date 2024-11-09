package com.biblio.mapper;

import com.biblio.dto.request.CustomerActiveInActiveRequest;
import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.entity.Account;
import com.biblio.entity.Address;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EMembership;
import com.biblio.enumeration.EUserRole;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        customer.setAccount(account);
        Address address = new Address();
        address.setNation("Việt Nam");
        address.setProvince(customerRegisterRequest.getProvince());
        address.setDistrict(customerRegisterRequest.getDistrict());
        address.setVillage(customerRegisterRequest.getVillage());
        address.setDetail(customerRegisterRequest.getDetail());
        customer.getAddresses().add(address);
        customer.setAvatar(customerRegisterRequest.getAvatar());
        customer.setJoinAt(LocalDateTime.now());
        customer.setMembership(EMembership.MEMBER);
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
        customerGetListResponse.setStatus(customer.getAccount().getStatus().toString());
        customerGetListResponse.setUsername(customer.getAccount().getUsername());
        customerGetListResponse.setPassword(customer.getAccount().getPassword());

        for (Address address : customer.getAddresses()) {
            customerGetListResponse.getAddresses().add(AddressMapper.toAddressResponse(address));
        }

        return customerGetListResponse;
    }

    public static Customer toCustomerActiveInActiveRequest(CustomerActiveInActiveRequest customerActiveInActiveRequest) {
        Customer customer = new Customer();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        customer.setId(customerActiveInActiveRequest.getId());
        customer.setAvatar(customerActiveInActiveRequest.getAvatar());
        customer.setDateOfBirth(customerActiveInActiveRequest.getDateOfBirth());
        customer.setEmailAddress(customerActiveInActiveRequest.getEmail());
        customer.setFullName(customerActiveInActiveRequest.getFullName());
        customer.setGender(EGender.valueOf(customerActiveInActiveRequest.getGender()));
        customer.setJoinAt( LocalDateTime.parse(customerActiveInActiveRequest.getJoinAt(), formatter));
        customer.setPhoneNumber(customerActiveInActiveRequest.getPhoneNumber());
        customer.setMembership(customerActiveInActiveRequest.getMemberShip());
        customer.getAccount().setStatus(customerActiveInActiveRequest.getStatus());
        customer.getAccount().setUsername(customerActiveInActiveRequest.getUsername());
        return customer;
    }

}
