package com.biblio.mapper;

import com.biblio.dto.request.CustomerRegisterRequest;
import com.biblio.dto.response.CustomerGetListResponse;
import com.biblio.dto.response.CustomerRegisterResponse;
import com.biblio.entity.Account;
import com.biblio.entity.Address;
import com.biblio.entity.Customer;
import com.biblio.enumeration.EAccountStatus;
import com.biblio.enumeration.EGender;
import com.biblio.enumeration.EMembership;
import com.biblio.enumeration.EUserRole;
import com.biblio.utils.BCryptUtil;

import java.time.LocalDateTime;
import java.util.Optional;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRegisterRequest request) {

        Customer customer = Customer.builder()
                .fullName(request.getFullName())
                .emailAddress(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth())
                .gender(EGender.valueOf(request.getGender()))
                .account(Account.builder()
                        .username(request.getUsername())
                        .password(BCryptUtil.HashPassword(request.getPassword()))
                        .userRole(EUserRole.CUSTOMER)
                        .status(EAccountStatus.ACTIVE)
                        .build())
                .avatar(request.getAvatar())
                .joinAt(LocalDateTime.now())
                .membership(EMembership.MEMBER)
                .address(Address.builder()
                        .nation("Việt Nam")
                        .province(request.getProvince())
                        .district(request.getDistrict())
                        .village(request.getVillage())
                        .detail(request.getDetail())
                        .customer(null)
                        .build())
                .build();

        customer.getAddresses().forEach(address -> address.setCustomer(customer));
        return customer;
    }

    public static CustomerRegisterResponse toCustomerRegisterResponse(Customer customer) {

        Optional<Address> optionalAddress = customer.getAddresses().stream().findFirst();

        return CustomerRegisterResponse.builder()
                .fullName(customer.getFullName())
                .email(customer.getEmailAddress())
                .dateOfBirth(customer.getDateOfBirth())
                .gender(customer.getGender() != null ? customer.getGender().toString() : null)
                .username(customer.getAccount() != null ? customer.getAccount().getUsername() : null)
                .password(customer.getAccount() != null ? customer.getAccount().getPassword() : null)
                .province(optionalAddress.map(Address::getProvince).orElse(null))
                .district(optionalAddress.map(Address::getDistrict).orElse(null))
                .village(optionalAddress.map(Address::getVillage).orElse(null))
                .detail(optionalAddress.map(Address::getDetail).orElse(null))
                .avatar(customer.getAvatar())
                .phoneNumber(customer.getPhoneNumber() != null ? String.valueOf(customer.getPhoneNumber()) : null)
                .joinAt(customer.getJoinAt())
                .build();
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


}
