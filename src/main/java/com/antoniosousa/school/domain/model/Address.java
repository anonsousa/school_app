package com.antoniosousa.school.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String street;
    @Column(nullable = false, length = 12)
    private String number;
    @Column(nullable = false, length = 60)
    private String city;
    @Column(nullable = false, length = 30)
    private String state;
    @Digits(integer = 9, fraction = 0)
    private String zip;

}
