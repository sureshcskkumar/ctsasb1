package com.demo.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
public class EnglishConverter implements MessageConverter {
	@Override
	public String translate(String message) {
		return "English: "+message;
	}

	
	
//	@Bean
//	public MessageConverter getMessageConverter() {
//		return new EnglishConverter();
//	}
}
