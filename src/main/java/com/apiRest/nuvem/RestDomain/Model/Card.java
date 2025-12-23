package com.apiRest.nuvem.RestDomain.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    @Column(name = "car_limit", scale = 2, precision = 13, nullable = false)
    private BigDecimal limit;

    public Card(String number, BigDecimal limit) {
        this.number = number;
        this.limit = limit;
    }
    public Card(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
