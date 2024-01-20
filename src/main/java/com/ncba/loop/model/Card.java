package com.ncba.loop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ncba.loop.repository.CardType;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "card_alias")
    private String cardAlias;



    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;
    
    
    
    // Constructors, getters, and setters
       
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", unique = true)
    @JsonBackReference
    private Account account;
    
    

    // Constructors
    public Card() {
        // Default constructor
    }

    public Card(String cardAlias, Long accountId, CardType cardType, Account account) {
        this.cardAlias = cardAlias;
        this.cardType = cardType;
    }

    // Getters and setters
    public Long getCardId() {
        return cardId;
    }

    public String getCardAlias() {
        return cardAlias;
    }

    public void setCardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}

