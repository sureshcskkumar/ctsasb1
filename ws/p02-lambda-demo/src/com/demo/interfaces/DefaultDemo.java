package com.demo.interfaces;

interface Atm{
	public int debit();
	public void changePin();
	public void printMiniStatement();
	public int checkBalance();
}

interface BankVisitor{
	public int debit();
	public void credit(int a);
	public int checkBalance();
	public void applyLoan();
}
interface NetBanking{
	public void changePin();
	public int checkBalance();
	public void applyLoan();
	public void payEmi(int a);
}


interface Bank extends Atm, BankVisitor, NetBanking{
	default public int debit() {return 0;}
	default public void changePin() {}
	default public void printMiniStatement(){}
	default public int checkBalance(){return 0;}
	default public void credit(int a){}
	default public void applyLoan(){}
	default public void payEmi(int a){}
}


public class DefaultDemo implements Bank {

}
