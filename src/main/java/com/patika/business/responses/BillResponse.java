package com.patika.business.responses;

import com.patika.dataAccess.BillTypeRepository;
import com.patika.dataAccess.MemberAccountRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillResponse {
    private Integer id;
    private Double amount;
    private Date processDate;
    private BillTypeResponse billType;
    private MemberAccountResponse memberAccount;
    private Boolean isPayment;
}
