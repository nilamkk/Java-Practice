package com.java.DesignPatterns.BuilderDP.TraditionalImplementation;

public abstract class DesktopBuilder {

	protected Desktop desktop;
	
	public DesktopBuilder() {
		this.desktop = new Desktop();
	}
	
	abstract public void buildMonitor();
	abstract public void buildKeyboard();
	abstract public void buildSpeaker();
	abstract public void buildMouse();
	abstract public void buildRam();
	abstract public void buildProcessor();
	abstract public void buildMotherBoard();
	abstract public void buildBrand();
	
	public Desktop getDesktop() {
		return this.desktop;
	}
	
}
