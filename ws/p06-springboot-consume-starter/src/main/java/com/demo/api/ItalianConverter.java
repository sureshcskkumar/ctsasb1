package com.demo.api;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ItalianConverter implements MessageConverter {
	@Override
	public String translate(String message) {
		return "Italian: "+message;
	}
}
