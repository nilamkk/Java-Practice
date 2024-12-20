package com.java.DesignPatterns.SingletonDP;

class Logger {
	private static volatile Logger logger;
	
	private Logger() { 
		if( logger != null ) { 
			// Even this is not full proof. Before getting the instance for the very first time through getLogger, reflection can create 
			// as many Instances as it want.
			throw new RuntimeException("Triggered this by Reflection!"); 
		}
	}
	
	// Regarding Copy constructor:
	// In CPP by default copy constructor is public, so while implementing singleton we need to make sure that copy constructor 
	// is made explicitly private.
	// But in java, the default copy constructor is not there, so chilllll!
	
	// Regarding = operator:
	// In CPP = operator is by default overloaded for objects, so while implementing singleton we need to make sure that operator = 
	// overloading is explicitly made as private.
	// But in java, the default operator overloading is not there, so chilllll! 
	
	public static Logger getLogger() {
		// double checked if check
		if( logger == null ) {				// Double checked locking: This is required because you need to take the lock only when the instance is getting created.
											// once you have created the instance there is no need to take the lock
			
			synchronized(Logger.class) {   // Original lock: This lock is important because multiple threads can enter the if statement one by one.
				// original if check
				if( logger == null ) {
					logger = new Logger();
				}	
			}
			
			
		}
		return logger;
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}
}

class DummyThread extends Thread{
	public void run() {
		Logger logger = Logger.getLogger();
		System.out.println(logger);
	}
}


public class Demo {

	public static void main(String[] args) {
		
		/////////////////////// Logger example /////////////////////////

		Logger logger1 = Logger.getLogger();
		
		Logger logger2 = Logger.getLogger();
		
		logger1.log("Smart logger!");
		
		System.out.println(logger1);
		System.out.println(logger2);
		
		
		//////////////////////// Creation of logger by different threads ///////////////////
//		Thread thread1 =  new DummyThread();
//		Thread thread2 =  new DummyThread();
//		
//		thread1.start(); // Although after several attempts, it creates two instances.
//		thread2.start();
		
	}

}
