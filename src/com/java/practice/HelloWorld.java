package com.java.practice;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("I am your first java code :)");

		System.out.println("And...");		
		
		
		// 2. Within same package. 
		Pikachu localPikachu = new Pikachu();
		System.out.println("Pikachu showing its features:");		
		System.out.println(localPikachu.colour); // public 
		System.out.println(localPikachu.pokemonType); // protected
		System.out.println(localPikachu.weight); // default
		// System.out.println(localPikachu.specialAttack); // private members cann't be accessed here.

		AccessModifiers accModifiers  = new AccessModifiers();
		System.out.println(accModifiers.publicNumber);
		System.out.println(accModifiers.protectedNumber);
		System.out.println(accModifiers.defaultNumber);
		// System.out.println(accModifiers.privateNumber); // private members cann't be accessed here.
		
		
		
		// 3. Within same package and from subclass. 
		Raichu localRaichu = new Raichu();
		System.out.println("Raichu showing its features:");		
		System.out.println(localRaichu.colour);
		System.out.println(localRaichu.pokemonType);
		System.out.println(localRaichu.weight);
		// System.out.println(localRaichu.evolvedSpecialAttack); // private members cann't be accessed here.		
		
		
	}

}
