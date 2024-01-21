package com.ncba.loop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ncba.loop.repository.CardType;
import com.ncba.loop.service.InvalidCardTypeException;

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
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cards")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "card_alias", nullable = false)
    private String cardAlias;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", updatable = false, nullable = false)
    private CardType cardType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", unique = true)
    @JsonBackReference
    private Account account;

    
    
    // Constructors, getters, and setters...

    // Default constructor
    public Card() {
        // Default constructor
    }

    public Card(String cardAlias, CardType cardType, Account account, Long accountId) {
        this.cardAlias = cardAlias;
        this.cardType = cardType;
    }

    // Other constructors...

    // Getters and setters...

    public Long getCardId() {
        return cardId;
    }

    public String getCardAlias() {
        return cardAlias;
    }

    public void setCardAlias(String cardAlias) {
        this.cardAlias = cardAlias;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    

    // Other methods...

    public CardResponseDTO toResponseDTO() {
        CardResponseDTO responseDTO = new CardResponseDTO();
        responseDTO.setCardId(this.cardId);
        responseDTO.setCardAlias(this.cardAlias);
        responseDTO.setAccountId((this.account != null) ? this.account.getAccountId() : null);
        responseDTO.setCardType(this.cardType);
        return responseDTO;
    }
    
    
    
}
