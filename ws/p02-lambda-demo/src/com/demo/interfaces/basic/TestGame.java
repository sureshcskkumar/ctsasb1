package com.demo.interfaces.basic;

interface Player{
	public void hit(Player p);
	public void eat(String food);
}

class WhitePlayer implements Player{

	@Override
	public void hit(Player p) {
		System.out.println("Reduce 5 units power from "+p);
	}
	@Override
	public void eat(String food) {
		System.out.println("Add 5 units power to my power level");
	}}
class BlackPlayer implements Player{
	@Override
	public void hit(Player p) {
		System.out.println("Reduce 3 units power from "+p);
	}
	@Override
	public void eat(String food) {
		System.out.println("Add 7 units power to my power level");
	}}


class Game{}

public class TestGame {

}
