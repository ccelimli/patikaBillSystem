package com.patika.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillRequest {
    private Integer id;
    private Double amount;
    private Date processDate;
    private Integer billTypeId;
    private Integer memberAccountId ;
    private Boolean isPayment;
}
