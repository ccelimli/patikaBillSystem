package com.patika.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberAccountResponse {
    private Integer id;
    private String name;
    private String surname;
    private String memberCode;
    private Double balance;
}

