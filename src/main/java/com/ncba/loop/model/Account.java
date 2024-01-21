package com.ncba.loop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "bic_swift", nullable = false)
    private String bicSwift;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    @JsonIgnore
    private Card card;

    // Constructors...

    // Default constructor
    public Account() {
        // Default constructor
    }

    // Constructor with necessary fields
    public Account(String iban, String bicSwift, Long clientId) {
        this.iban = iban;
        this.bicSwift = bicSwift;
        this.clientId = clientId;
    }

    // Other constructors...

    // Getters and setters...

    public Long getAccountId() {
        return accountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBicSwift() {
        return bicSwift;
    }

    public void setBicSwift(String bicSwift) {
        this.bicSwift = bicSwift;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    // Other methods...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", iban='" + iban + '\'' +
                ", bicSwift='" + bicSwift + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}

