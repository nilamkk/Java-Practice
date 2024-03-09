package com.java.practice.Multithreading;

// Thread class extending Thread class
class ProducerThread extends Thread{
	public void run() {
		for(int i=0; i< 1000; i++) {
			System.out.println("Producer producing **********");
		}
	}
}

// Thread class created implementing Runnable interface
class ConsumerThread implements Runnable{
	@Override
	public void run() { 
		for(int i=0; i< 1000; i++) {
			System.out.println("Consumer consuming ------------");
		}
	}
}

public class MyThread {

	public static void main(String[] args) {

		Thread producer = new ProducerThread();
		
		// Thread creation using Runnable interface needs an extra step
		Runnable consumerRunnable = new ConsumerThread(); // can also pass thread name as a first parameter
		Thread consumer = new Thread(consumerRunnable); // can also pass thread name as a second parameter

		// Setting priorities
		// producer.setPriority(Thread.MAX_PRIORITY);
		// consumer.setPriority(Thread.MIN_PRIORITY);
		// consumer.setPriority(Thread.NORM_PRIORITY);
		
		// Starting both of the threads
		producer.start();
		consumer.start();
		
		System.out.println( producer.getId() );
		// System.out.println( producer.getName() );
		
	}
}
