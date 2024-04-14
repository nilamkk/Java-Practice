package com.java.DesignPatterns.BuilderDP.TraditionalImplementation;

public class Demo {

	public static void main(String[] args) {
		
		DesktopBuilder dellDesktopBuilder = new DellDesktopBuilder();
		DesktopDirector desktopDirector = new DesktopDirector(dellDesktopBuilder);
		
		Desktop dellDesktop = desktopDirector.buildDesktop();
		
		dellDesktop.showSpecifications();
		
	}

}
