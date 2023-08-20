package com.patika.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="MEMBERACCOUNTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name="Surname")
    private String surname;
    @Column(name = "Code")
    private String memberCode;
    @Column(name = "Balance")
    private Double balance;

    @OneToMany(mappedBy = "memberAccount")
    private List<Bill> bill;

}