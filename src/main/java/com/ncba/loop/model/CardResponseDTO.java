package com.ncba.loop.model;

import com.ncba.loop.repository.CardType;

public class CardResponseDTO {
	 private Long cardId;
	    private String cardAlias;
	    private Long accountId;
	    private CardType cardType;
	    
	    
	 // Constructors, getters, and setters...

	    public Long getCardId() {
	        return cardId;
	    }

	    public void setCardId(Long cardId) {
	        this.cardId = cardId;
	    }

	    public String getCardAlias() {
	        return cardAlias;
	    }

	    public void setCardAlias(String cardAlias) {
	        this.cardAlias = cardAlias;
	    }

	    public Long getAccountId() {
	        return accountId;
	    }

	    public void setAccountId(Long accountId) {
	        this.accountId = accountId;
	    }

	    public CardType getCardType() {
	        return cardType;
	    }

	    public void setCardType(CardType cardType) {
	        this.cardType = cardType;
	    }
}
