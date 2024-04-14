package com.java.DesignPatterns.BuilderDP.TraditionalImplementation;

public class DesktopDirector {
	private DesktopBuilder desktopBuilder;
	
	public DesktopDirector( DesktopBuilder pDesktopBuilder) {
		this.desktopBuilder = pDesktopBuilder;
	}
	
	public Desktop getDesktop() {
		return this.desktopBuilder.getDesktop();
	}
	
	public Desktop buildDesktop() {
		this.desktopBuilder.buildBrand();
		this.desktopBuilder.buildKeyboard();
		this.desktopBuilder.buildMotherBoard();
		this.desktopBuilder.buildMonitor();
		this.desktopBuilder.buildMouse();
		this.desktopBuilder.buildProcessor();
		this.desktopBuilder.buildRam();
		this.desktopBuilder.buildSpeaker();
		
		return this.desktopBuilder.getDesktop();
	}
	
}
