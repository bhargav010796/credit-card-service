package com.card.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.card.service.entity.CreditCardDTO;
import com.fasterxml.jackson.databind.ObjectMapper;



public class TestCreditController extends SpringBootHelloWorldTests {
	
	private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
	public void whenValidURIForGetAllCreditCards() throws Exception {
		mvc.perform(get("/getAllCreditCards")).andExpect(status().isOk());

	}
    
    @Test
	public void whenInValidURIForGetAllCreditCards() throws Exception {
		mvc.perform(get("/getAllCredis")).andExpect(status().isNotFound());

	}
    
    @Test
	public void whenTereIsStringContainsCheckNumber() throws Exception {
		mvc.perform(post("/addCreditCard").content(asJsonString(new CreditCardDTO("test", "adda5fsgfg", 3000)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());	
		
	}
    
    @Test
	public void whenTereIsNotValidCheckNumber() throws Exception {
		mvc.perform(post("/addCreditCard").content(asJsonString(new CreditCardDTO("test", "1234 4355 3253 2344", 3000)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest());
		
	}
    
    
    @Test
   	public void whenTereIsValidCheckNumber() throws Exception {
   		mvc.perform(post("/addCreditCard").content(asJsonString(new CreditCardDTO("test", "374245455400126", 3000)))
   			      .contentType(MediaType.APPLICATION_JSON)
   			      .accept(MediaType.APPLICATION_JSON))
   			      .andExpect(status().isOk());
   		
   	}
    
    


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    

	

}
