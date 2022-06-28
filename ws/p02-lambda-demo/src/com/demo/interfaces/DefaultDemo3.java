package com.demo.interfaces;

interface Account{
	void open(String type);
	default void applyLoan() {
		System.out.println("in account interface");
	}
	static void roi() {
		System.out.println("ROI: "+5+"%");
	}
}

class MyBank implements Account {

	@Override
	public void applyLoan() {
		System.out.println("in myBank");
	}
	
	@Override
	public void open(String type) {
		System.out.println("Your "+type+" account has been openned successfully in myBank");
	}
}
class YourBank implements Account {

	@Override
	public void open(String type) {
		System.out.println("Your "+type+" account has been openned successfully in yourBank");
	}
	
//	@Override
//	public void roi() {
//		System.out.println("ROI: "+10+"%");
//	}
}

public class DefaultDemo3 {
	
	public static void main(String[] args) {
		Account account1 = new MyBank();
		account1.open("savings");
		account1.applyLoan();
//		account1.roi();
		Account.roi();
		
		Account account2 = new YourBank();
		account2.open("current");
		account2.applyLoan();
//		account2.roi();
		Account.roi();

	}
	
}
