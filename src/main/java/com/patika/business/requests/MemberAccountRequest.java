package com.patika.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberAccountRequest {
    private Integer id;
    private String name;
    private String surname;
    private Double balance;
}
