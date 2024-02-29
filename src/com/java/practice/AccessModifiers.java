package com.java.practice;

// This is a helper class which can only be used within this package only and nowhere else.
class Pikachu{
	public String colour = "Yellow";
	protected String pokemonType = "Electric";
	private String specialAttack = "Thunderbolt ";
	int weight = 5; // with no access modifiers or default
	
	// 1. Obviously, within same class all the variables above can be accessed.
	
	public void Attack() {
		System.out.println("Pikachu is attacking with " + specialAttack );
	}
}

// This is a helper class which can only be used within this package only and nowhere else.
class Raichu extends Pikachu{
	private String evolvedSpecialAttack = "Star-Shaped Thunderbolt";
		
	public void showOldCharacters() {
		// 3. Subclass can access these from super class
		System.out.println(colour); // public
		System.out.println(pokemonType); // protected
		System.out.println(weight); // default
		// System.out.println(specialAttack); // private members of super class are not accessible here
	}
	
	public void EvoAttack() {
		System.out.println("Pikachu is attacking with " + evolvedSpecialAttack );
	}
}

// This is the one and only one public class this file can have. This can be used outside this package.
public class AccessModifiers {
	
	public Pikachu pikachu;
	public Raichu raichu;
	
	public int publicNumber;
	private int privateNumber;
	protected int protectedNumber;
	int defaultNumber;
	
	
	public AccessModifiers(){
		this.pikachu = new Pikachu();
		this.raichu = new Raichu();
	
		// Initialize numbers
		publicNumber = 1;
		privateNumber = 2;
		protectedNumber = 3;
		defaultNumber = 4;
	
	}
	
	public int getPrivateNumber() {
		return privateNumber;
	}

	public static void main(String[] args) {
		
		// 2. Within same package. 
		Pikachu localPikachu = new Pikachu();
		System.out.println("Pikachu showing its features:");		
		System.out.println(localPikachu.colour); // public 
		System.out.println(localPikachu.pokemonType); // protected
		System.out.println(localPikachu.weight); // default
		// System.out.println(localPikachu.specialAttack); // private members cann't be accessed here.

		// 3. Within same package and from subclass. 
		Raichu localRaichu = new Raichu();
		System.out.println("Raichu showing its features:");		
		System.out.println(localRaichu.colour);
		System.out.println(localRaichu.pokemonType);
		System.out.println(localRaichu.weight);
		// System.out.println(localRaichu.evolvedSpecialAttack); // private members cann't be accessed here.	
		
	}

}
