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

import com.ncba.loop.model.Account;
import com.ncba.loop.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	  private AccountRepository accountRepository;

	  @GetMapping("/ping-account")
	  public String ping() {
	    return "pong account";
	  }
	  
	  @PostMapping("/create-account")
	  public Account createAccount(@RequestBody Account accountInfo) {
	    return accountRepository.save(accountInfo);
	  }
	  
	  @GetMapping("getaccount-by-id/{id}")
	  public Account getAccountById(@PathVariable Long id) {
	    return accountRepository.findById(id).get();
	  }
	  
	  @PostMapping("/create-accounts")
	  public List<Account> createAccounts(@RequestBody List<Account> accountList) {
	     return accountRepository.saveAll(accountList);
	  }
	  
	  @GetMapping("/get-accounts")
	  public List<Account> getAllAccounts() {
	    return accountRepository.findAll();
	  } 
	  
	  
	  @PutMapping("/update-account/{accountId}")
	   public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account updatedAccount) {
	        return accountRepository.findById(accountId)
	                .map(existingAccount -> {
	                    existingAccount.setIban(updatedAccount.getIban());
	                    existingAccount.setBicSwift(updatedAccount.getBicSwift());
	                    existingAccount.setClientId(updatedAccount.getClientId());

	                    Account savedAccount = accountRepository.save(existingAccount);
	                    return ResponseEntity.ok().body(savedAccount);
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	  }
	  
	  @DeleteMapping("/delete-account/{accountId}")
	    public ResponseEntity<Object> deleteAccount(@PathVariable Long accountId) {
	        return accountRepository.findById(accountId)
	                .map(existingAccount -> {
	                    accountRepository.deleteById(accountId);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	  
}
