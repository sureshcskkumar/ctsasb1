package com.pwd.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncoderDemo {

	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String encodedStr1 = encoder.encode("admin@123");
		String encodedStr2 = encoder.encode("user@123");
		String encodedStr3 = encoder.encode("manager@123");
		System.out.println(encodedStr1);
		System.out.println(encodedStr2);
		System.out.println(encodedStr3);
	}
	
}
