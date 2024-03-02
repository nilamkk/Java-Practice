package com.java.practice.abstractclass;

abstract class localAbstractClass{
	
	public void start() {
		System.out.println("The thing is getting started...");
	}
	abstract public void blowHorn();
}

abstract class localAbstractClass2 extends localAbstractClass{
	abstract public void blowHorn2();
}


class MainClass extends localAbstractClass2{

	@Override
	public void blowHorn2() {
		System.out.println("Blow horn 2...");
		
	}

	@Override
	public void blowHorn() {
		System.out.println("Blow horn 1...");
		
	}
	
}

public class AbstractClass {

	public static void main(String[] args) {
		MainClass mclass = new MainClass();
		
		mclass.start();
		mclass.blowHorn();
		mclass.blowHorn2();

	}

}
