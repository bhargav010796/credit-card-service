package com.card.service.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.service.entity.CreditCard;
import com.card.service.entity.CreditCardDTO;
import com.card.service.entity.CreditCardViewDTO;
import com.card.service.repository.CreditCardRepository;

@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditCardRepository repository;

	@Override
	public List<CreditCard> getAllCreditCard() {
		return repository.findAll();
	}

	@Override
	public CreditCardViewDTO addCreditCard(CreditCardDTO dto) {
		CreditCard newCard = new CreditCard();
		newCard.setCardNumber(dto.getCardNumber().replaceAll(" ", ""));
		newCard.setCardLimit(dto.getCardLimit());
		newCard.setName(dto.getName());
		repository.save(newCard);

		CreditCard cardEntity = repository.findByCardNumber(dto.getCardNumber());
		CreditCardViewDTO resultDto = new CreditCardViewDTO();
		BeanUtils.copyProperties(cardEntity, resultDto);
		
		return resultDto;
	}

	@Override
	public boolean existsByCardNumber(String cardNumber) {
		return repository.existsByCardNumber(cardNumber);
	}

}
