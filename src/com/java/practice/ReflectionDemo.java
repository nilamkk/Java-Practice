package com.java.practice;

import java.lang.reflect.Constructor;

class Logger {
	
	private static volatile Logger logger;
	
	private Logger() {
		System.out.println("Private Logger constructor called!");
	}
	
	public static Logger getInstance() {
		if( logger == null ) {
			logger = new Logger();
		}
		return logger;
	}
	
	public void introduceYourself() {
		System.out.println("I am Logger's introduction!");
	}
	
}

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {
		
		Logger logger1 = Logger.getInstance();
		
		Logger logger2 = Logger.getInstance();
		
		try {
			
			Class c = Class.forName("com.java.practice.Logger");
			
			Constructor cons = c.getDeclaredConstructor(); // Getting the constructor
			
			cons.setAccessible(true); // Setting the visibility so we can access private constructor
			
			Logger reflectedLogger = (Logger)cons.newInstance(); // Loop hole to create Logger instance even when singleton is implemented
			
			reflectedLogger.introduceYourself();
			
			System.out.println("Logger1          --> "+ logger1);
			System.out.println("Logger2          --> "+ logger2);
			System.out.println("Reflected Logger --> " + reflectedLogger);
			
		}catch(Exception excep) {
			System.out.println(excep);
		}
		
	}

}
