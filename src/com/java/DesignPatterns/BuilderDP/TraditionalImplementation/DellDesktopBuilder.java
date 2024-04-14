package com.java.DesignPatterns.BuilderDP.TraditionalImplementation;

public class DellDesktopBuilder extends DesktopBuilder {

	@Override
	public void buildMonitor() {
		this.desktop.setMonitor("Dell Monitor S2721HN");
	}

	@Override
	public void buildKeyboard() {
		this.desktop.setKeyboard("Dell Keyboard KB500");
	}

	@Override
	public void buildSpeaker() {
		this.desktop.setSpeaker("Dell Speaker AX210");
	}

	@Override
	public void buildMouse() {
		this.desktop.setMouse("Dell Mouse MS320");
	}

	@Override
	public void buildRam() {
		this.desktop.setRam("Dell RAM 4gb");
	}

	@Override
	public void buildProcessor() {
		this.desktop.setProcessor("Dell Processor P220");
	}

	@Override
	public void buildMotherBoard() {
		this.desktop.setMotherBoard("Dell Mother Board MB092");
	}

	@Override
	public void buildBrand() {
		this.desktop.setBrand("Dell");
	}

}
