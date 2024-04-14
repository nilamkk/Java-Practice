package com.java.DesignPatterns.BuilderDP.TraditionalImplementation;

public class Desktop {
	
	private String monitor;
	private String keyboard;
	private String speaker;
	private String mouse;
	private String ram;
	private String processor;
	private String motherBoard;
	private String brand;
	
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void showSpecifications() {
		System.out.println(" ************************************* ");
		System.out.println("Desktop brand - "+ this.brand);
		System.out.println("Monitor - "+ this.monitor);
		System.out.println("Keyboard - "+ this.keyboard);
		System.out.println("Speaker - "+ this.speaker);
		System.out.println("Mouse - "+ this.mouse);
		System.out.println("Ram - "+ this.ram);
		System.out.println("Processor - "+ this.processor);
		System.out.println("Mother Board  - "+ this.motherBoard );
		System.out.println(" ************************************* ");
	}
	
}
