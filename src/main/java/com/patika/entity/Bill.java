package com.patika.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "BILLS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "Process_Date")
    private Date processDate;
    @Column(name = "is_payment")
    private Boolean isPayment;
    @Column(name = "code")
    private String code;
    @OneToOne
    @JoinColumn(name = "bill_type_id", referencedColumnName = "id")
    private BillType billType;
    @ManyToOne
    @JoinColumn(name = "member_account_id", nullable = true)
    private MemberAccount memberAccount;
}