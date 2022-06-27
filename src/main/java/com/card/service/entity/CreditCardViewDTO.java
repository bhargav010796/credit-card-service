package com.card.service.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class CreditCardViewDTO extends CreditCardDTO{

	private BigDecimal balance;
}
