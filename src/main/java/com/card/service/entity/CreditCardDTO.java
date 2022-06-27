package com.card.service.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDTO {
	
	private String name;
	private String cardNumber;
	private Integer cardLimit;

}


