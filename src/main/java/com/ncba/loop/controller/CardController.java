package com.ncba.loop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncba.loop.model.Card;
import com.ncba.loop.model.CardResponseDTO;
import com.ncba.loop.repository.CardRepository;
import com.ncba.loop.service.CardService;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/cards")
public class CardController {
	 @Autowired
	  private CardRepository cardRepository;
	 
	 @Autowired
	  private CardService cardService;
	 

	  @GetMapping("/ping-card")
	  public String ping() {
	    return "pong card";
	  }
	  
	  
	  
	  @PostMapping("/create-card")
	  public ResponseEntity<CardResponseDTO> createCard(@RequestBody Card cardInfo) {
		  return cardService.createCard(cardInfo);
	   // return cardRepository.save(cardInfo);
	  }
	  
	  
	  
	  
	  @GetMapping("/cards/{id}")
	  public ResponseEntity<CardResponseDTO> getCardById(@PathVariable Long id) {
	      Card card = cardRepository.findById(id)
	              .orElseThrow(() -> new EntityNotFoundException("Card not found with id: " + id));

	      CardResponseDTO responseDTO = card.toResponseDTO();
	      return ResponseEntity.ok(responseDTO);
	  }
	  
	  
	  
	  
//	  @GetMapping("getcard-by-id/{id}")
//	  public Card getCardById(@PathVariable Long id) {
//	    return cardRepository.findById(id).get();
//	  }
	  
	  @PostMapping("/create-cards")
	  public List<Card> createCards(@RequestBody List<Card> cardList) {
	     return cardRepository.saveAll(cardList);
	  }
	  
	  @GetMapping("/get-cards")
	  public List<Card> getAllCards() {
	    return cardRepository.findAll();
	  } 
	  
	  
	  @PutMapping("/update-card/{cardId}")
	    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody Card updatedCard) {
	        return cardRepository.findById(cardId)
	                .map(existingCard -> {
	                    existingCard.setCardAlias(updatedCard.getCardAlias());
	                    Card savedCard = cardRepository.save(existingCard);
	                    return ResponseEntity.ok().body(savedCard);
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	  
	  
	  
	  @DeleteMapping("/delete-card/{cardId} ")
	    public ResponseEntity<Object> deleteCard(@PathVariable Long cardId) {
	        return cardRepository.findById(cardId)
	                .map(existingCard -> {
	                    cardRepository.deleteById(cardId);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
}
