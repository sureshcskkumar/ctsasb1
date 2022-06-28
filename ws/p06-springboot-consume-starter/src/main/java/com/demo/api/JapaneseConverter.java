package com.demo.api;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class JapaneseConverter implements MessageConverter {
	@Override
	public String translate(String message) {
		return "Japanese: "+message;
	}
}
