package com.apiRest.nuvem.RestDomain.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_accont")
public class Accont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_accont;
    @Column(unique = true)
    private String number;
    private String agency;
    @Column(scale = 2, precision = 13, nullable = false)
    private BigDecimal balance;
    @Column(name = "accont_limit",scale = 2, precision = 13, nullable = false)
    private BigDecimal limit;

    public Accont(String number, String agency, BigDecimal balance, BigDecimal limit) {
        this.number = number;
        this.agency = agency;
        this.balance = balance;
        this.limit = limit;
    }

public Accont(){}


    public Long getId_accont() {
        return id_accont;
    }

    public void setId_accont(Long id_accont) {
        this.id_accont = id_accont;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
