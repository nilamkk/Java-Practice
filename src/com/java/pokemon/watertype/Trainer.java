package com.java.pokemon.watertype;

import com.java.practice.AccessModifiers;
import com.java.practice.HelloWorld;

class TrainerAccess extends AccessModifiers{
	
	public TrainerAccess(){
		// 5. Inheritance in different package
		// this.pikachu = new Pikachu(); // Not possible, since Pikachu type is not visible in this package
		// this.raichu = new Raichu(); // Not possible, since Raichu type is not visible in this package
	
		// Initialize numbers
		publicNumber = 1; 
		protectedNumber = 3;
		// defaultNumber = 4; // Default members are not inherited inside different package
		// privateNumber = 2; // Private members are not inherited inside different package
	}
	
	public void getAttributes() {
		System.out.println("Public number is " + publicNumber);
		System.out.println("Protected number is " + protectedNumber);
		System.out.println("Default number is not inherited. Hence not available!" );
		System.out.println("Private number is not inherited. Hence not available!");
	}
}

public class Trainer {

	public static void main(String[] args) {
		
		HelloWorld helloWorld = new HelloWorld();
		
		// 4. From different package (WORLD)
		AccessModifiers accessModifiers = new AccessModifiers();
		System.out.println(accessModifiers.publicNumber);
		// System.out.println(accessModifiers.protectedNumber); // Protected numbers can't be accessed.
		// System.out.println(accessModifiers.defaultNumber); // Default numbers can't be accessed here.		
		// System.out.println(accessModifiers.privateNumber); // Private members cann't be accessed here.
		// This is not possible. Reason: the pikachu variable is available here but the type Pikachu is not available in this package
		// accessModifiers.pikachu.Attack();
		
		
		// For TrainerAccess class
		TrainerAccess trainerAccess = new TrainerAccess();
		trainerAccess.getAttributes();
		System.out.println(trainerAccess.publicNumber);
		// System.out.println(trainerAccess.protectedNumber); // Although it is inherited, it is not accessible inside Trainer class since it is in another package
		// System.out.println(trainerAccess.defaultNumber);
		// System.out.println(trainerAccess.privateNumber);
		
		
	}

}
