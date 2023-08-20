package com.patika.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BILLTYPES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
}
