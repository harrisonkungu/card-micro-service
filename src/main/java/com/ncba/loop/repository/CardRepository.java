package com.ncba.loop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncba.loop.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
