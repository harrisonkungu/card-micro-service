package com.ncba.loop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
	@Table(name = "accounts")
	public class Account implements Serializable { 

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "account_id")
	    private Long accountId;

	    @Column(name = "iban")
	    private String iban;

	    @Column(name = "bic_swift")
	    private String bicSwift;

	    @Column(name = "client_id")
	    private Long clientId;
	    
	 
	    
	    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference // Used on the owning side of the relationship
	    private Card card;

	    // Constructors, getters, and setters

	    // Constructors
	    public Account() {
	        // Default constructor
	    }

	    public Account(String iban, String bicSwift, Long clientId) {
	        this.iban = iban;
	        this.bicSwift = bicSwift;
	        this.clientId = clientId;
	    }

	    // Getters and setters
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
	}
