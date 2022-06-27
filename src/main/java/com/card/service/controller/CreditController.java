package com.card.service.controller;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.service.entity.CreditCard;
import com.card.service.entity.CreditCardDTO;
import com.card.service.service.CreditService;
import com.card.service.validation.Validation;

@RestController
@CrossOrigin("*")
public class CreditController {
	
	@Autowired
	private CreditService service;
	
	@PostMapping("/addCreditCard")
	public ResponseEntity addCreditCard(@RequestBody CreditCardDTO card) {

		if (StringUtils.isBlank(card.getName())
				|| (StringUtils.isBlank(card.getCardNumber()) || !NumberUtils.isDigits(card.getCardNumber().replaceAll(" ", "")))
				|| card.getCardLimit() == null || !Validation.cardValidation(card.getCardNumber())
				|| service.existsByCardNumber(card.getCardNumber().replaceAll(" ", ""))) {
			return new ResponseEntity<>("Enter Valid Data.", HttpStatus.BAD_REQUEST);
		}
		CreditCardDTO newCard = service.addCreditCard(card);
		if (newCard == null) {
			return new ResponseEntity<>("Data Not Stored.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(newCard, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCreditCards")
	public List<CreditCard> getAllCreditCards(){	
		return service.getAllCreditCard();
	}
	

}
