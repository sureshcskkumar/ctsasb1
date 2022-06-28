package com.demo.p02;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

class Ticket{
	private String pnr;
	private String customerEmail;
	private LocalDate date;

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", customerEmail=" + customerEmail + ", date=" + date + "]";
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Ticket(String pnr, String customerEmail, LocalDate date) {
		super();
		this.pnr = pnr;
		this.customerEmail = customerEmail;
		this.date = date;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

class DummyDatabase{
	public static List<Ticket> getTicketsFromDb(){
		return Arrays.asList(
				new Ticket("mfa845", "mark@gmail.com", LocalDate.of(2022, 06, 18)),
				new Ticket("mfa241", "tom@gmail.com", LocalDate.of(2022, 07, 31)),
				new Ticket("mfa159", "miley@gmail.com", LocalDate.of(2022, 06, 18)),
				new Ticket("mfa753", "emily@gmail.com", LocalDate.of(2022, 06, 19)),
				new Ticket("mfa875", "john@gmail.com", LocalDate.of(2022, 06, 17)),
				new Ticket("mfa325", "mark@gmail.com", LocalDate.of(2022, 06, 20)),
				new Ticket("mfa968", "carl@gmail.com", LocalDate.of(2022, 06, 18))
			);
	}
}

public class Demo02_CompletableFutureChain {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		CompletableFuture.supplyAsync(()->{
			System.out.println("Find tickets from database: "+Thread.currentThread().getName());
			return DummyDatabase.getTicketsFromDb();
		}, executor).thenApplyAsync((tickets)->{
			System.out.println("Find tickets for next day flight: "+Thread.currentThread().getName());
			return tickets
					.stream()
					.filter(ticket->LocalDate.of(2022,06,18).equals(ticket.getDate()))
					.collect(Collectors.toList());
		}, executor).thenApplyAsync(tomTickets->{
			System.out.println("Find emails: "+Thread.currentThread().getName());
			return tomTickets
					.stream()
					.map(ticket->ticket.getCustomerEmail())
					.collect(Collectors.toList());
		}, executor).thenAcceptAsync(emails->{
			System.out.println("Sending mails: "+Thread.currentThread().getName());
			emails.stream().forEach(email->System.out.println("Seinding mail to: "+email));
		}, executor);
	}

	public static void main3(String[] args) {
		LocalDate date1 = LocalDate.of(2022, 04, 20);
		LocalDate date2 = LocalDate.of(2022, 04, 20);
				
		System.out.println(date1==date2);
		System.out.println(date1.equals(date2));
	}
	
}
