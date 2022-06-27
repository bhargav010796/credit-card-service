package com.card.service.service;

import java.util.List;

import com.card.service.entity.CreditCard;
import com.card.service.entity.CreditCardDTO;

public interface CreditService {
	
	List<CreditCard> getAllCreditCard();
	
	CreditCardDTO addCreditCard(CreditCardDTO newCard);
	
	boolean existsByCardNumber(String cardNumber);

}
