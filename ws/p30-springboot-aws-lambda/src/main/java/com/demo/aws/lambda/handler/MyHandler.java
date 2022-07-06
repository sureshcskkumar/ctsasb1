package com.demo.aws.lambda.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.demo.models.Book;


public class MyHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	@Autowired
	private List<Book> books;
	
	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		// TODO Auto-generated method stub
		
		// ?price = 45
		
		try {
			String p = input.getQueryStringParameters().get("price");
			double price = Double.parseDouble(p);
			List<Book> foundBooks = new ArrayList<Book>();
			books.forEach(book->{
				if(book.getPrice() > price) {
					foundBooks.add(book);
				}
			});
			return new APIGatewayProxyResponseEvent().withBody(foundBooks.toString()).withStatusCode(200);
		} catch(Exception e) {			
			return new APIGatewayProxyResponseEvent().withBody("Some error occurred").withStatusCode(200);
		}
		
	}

}
