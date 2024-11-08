package com.biblio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressResponse {
    private Long id;
    private String nation;
    private String province;
    private String district;
    private String village;
    private String detail;
}

