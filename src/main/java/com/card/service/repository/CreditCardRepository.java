package com.card.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.card.service.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String>{
	
	public boolean existsByCardNumber(String cardNumber);
	
	public CreditCard findByCardNumber(String cardNumber);

}
