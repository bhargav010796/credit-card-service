package com.card.service.validation;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	
	public static boolean cardValidation(String cardNumber) {
		
		cardNumber = cardNumber.replaceAll(" ", "");
		int sum = 0;
		boolean alternate = false;
		for (int i = cardNumber.length() - 1; i >= 0; i--) {
			int number = Integer.parseInt(cardNumber.substring(i, i + 1));
			if (alternate) {
				number *= 2;
				if (number > 9) {
					number = (number % 10) + 1;
				}
			}
			sum += number;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}
	

}
