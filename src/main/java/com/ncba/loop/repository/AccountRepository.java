package com.ncba.loop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncba.loop.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
