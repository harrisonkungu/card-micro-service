package com.ncba.loop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncba.loop.model.Account;
import com.ncba.loop.model.Card;
import com.ncba.loop.model.CardResponseDTO;
import com.ncba.loop.repository.AccountRepository;
import com.ncba.loop.repository.CardRepository;
import com.ncba.loop.repository.CardType;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;

import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CardService {
	
    private static final Logger logger = LoggerFactory.getLogger(CardService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

	
	@Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;
    
	    public  ResponseEntity<CardResponseDTO>  createCard(Card cardInfo) {
	  
	    		Long accountId = cardInfo.getAccount().getAccountId();
	    		CardType cardType = cardInfo.getCardType();
	    	  if (cardType != CardType.VIRTUAL && cardType != CardType.PHYSICAL) {
	              throw new InvalidCardTypeException("Invalid CardType. Allowed values: VIRTUAL, PHYSICAL");
	          }
	    	  
	    	
	    	Account account = accountRepository.findById(accountId)
	    			.orElseThrow(() -> new EntityNotFoundException("Account id: " + accountId + "not found"));
	    	 CardResponseDTO responseDTO = cardInfo.toResponseDTO();
	    	 return ResponseEntity.ok(responseDTO);
	    }
	    
	    
	    
	    public Card cardCreater(Card cardInfo, Long accountId) {
	        // Check if the account ID exists
	        Account account = null;
			try {
				account = accountRepository.findById(accountId)
				        .orElseThrow(() -> new AccountNotFoundException("Account ID not found: " + accountId));
			} catch (AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Set the account in the cardInfo
	        cardInfo.setAccount(account);

	        // Save the card
	        return cardRepository.save(cardInfo);
	    }
}
