package com.demo.interfaces;

interface SbiAtm{
	default public void debit(int a) {
		System.out.println("insert your card and verify pin");
		System.out.println("Debit is done: "+a);
	}
}

interface SbiBankVisitor{
	default public void debit(int a) {
		System.out.println("Confirm account number and signature");
		System.out.println("Debit is done: "+a);
	}
}


public class DefaultDemo2 implements SbiAtm, SbiBankVisitor {

	public static void main(String[] args) {
		DefaultDemo2 dd = new DefaultDemo2();
		dd.debit(5000);
	}

	@Override
	public void debit(int a) {
		SbiBankVisitor.super.debit(a);
		SbiAtm.super.debit(a);
		System.out.println("debit is done");
	}
	
}
