package com.card.service.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "credit_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	
	@Column(name = "card_name")
	private String name;
	
	@Id
	@Column(name = "card_number")	
	private String cardNumber;
	
	@Column(name = "balance")
	private BigDecimal balance = new BigDecimal(0);	
	
	@Column(name = "card_limit")
	private Integer cardLimit;
	
	

}
