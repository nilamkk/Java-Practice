package com.java.DesignPatterns.AbstractFactoryDP;


//////////////////////////////////////////// Button ///////////////////////////////////////////////
abstract class Button {
	
	int length;
	int width;
	final String operatingSystem;
	
	public Button(int length , int width, String operatingSystem) {
		this.length = length;
		this.width = width;
		this.operatingSystem = operatingSystem;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void showSpecs() {
		System.out.println("Length --> "+ this.length);
		System.out.println("Width --> "+ this.width);
		System.out.println("OS --> "+ this.operatingSystem);
	}
	
	abstract public void paint();
	
}

class WindowsButton extends Button {

	public WindowsButton(int length, int width, String operatingSystem) {
		super(length, width, operatingSystem);
	}

	@Override
	public void paint() {
		System.out.println("The button is painted in "+ this.operatingSystem);
		System.out.println("Painting button in Windows way!");
	}
}

class MacButton extends Button{

	public MacButton(int length, int width, String operatingSystem) {
		super(length, width, operatingSystem);
	}

	@Override
	public void paint() {
		System.out.println("The button is painted in "+ this.operatingSystem);
		System.out.println("Following Mac techniques for button...");
	}
}


//////////////////////////////////////////// CheckBox ///////////////////////////////////////////////
abstract class CheckBox {
	boolean checked;
	final String operatingSystem;
	
	public CheckBox(boolean checked, String operatingSystem) {
		this.checked = checked;
		this.operatingSystem = operatingSystem;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public void showSpecs() {
		System.out.println("Value --> "+ this.checked);
		System.out.println("OS --> "+ this.operatingSystem);
	}
	
	abstract public void paint();
}

class WindowsCheckBox extends CheckBox{

	public WindowsCheckBox(boolean checked, String operatingSystem) {
		super(checked, operatingSystem);
	}

	@Override
	public void paint() {
		System.out.println("The checkbox is painted in "+ this.operatingSystem);
		System.out.println("Painting checkbox in Windows way!");
	}
}

class MacCheckBox extends CheckBox{

	public MacCheckBox(boolean checked, String operatingSystem) {
		super(checked, operatingSystem);
	}

	@Override
	public void paint() {
		System.out.println("The checkbox is painted in "+ this.operatingSystem);
		System.out.println("Following Mac techniques for checkbox...");
	}
	
}

//////////////////////////////////////////// Factories ///////////////////////////////////////////////

interface GUIFactory{
	Button createButton(int length, int width);
	CheckBox createCheckBox(boolean checked);
}

class WindowsFactory implements GUIFactory{

	@Override
	public Button createButton(int length, int width) {
		return new WindowsButton(length, width, "Windows");
	}

	@Override
	public CheckBox createCheckBox(boolean checked) {
		return new WindowsCheckBox(checked, "Windows");
	}
}

class MacFactory implements GUIFactory{

	@Override
	public Button createButton(int length, int width) {
		return new MacButton(length, width, "Mac");
	}

	@Override
	public CheckBox createCheckBox(boolean checked) {
		return new MacCheckBox(checked, "Mac");
	}
}

class GUIAbstractFactory{
	public static GUIFactory createFactory() {
		String systemOs = System.getProperty("os.name");
		
		if( systemOs.toLowerCase().contains("windows") ) {
			return new WindowsFactory();
		}else if( systemOs.toLowerCase().contains("mac") ) {
			return new MacFactory();
		}
		return new MacFactory()	;
	}
}


public class Demo {

	public static void main(String[] args) {
		
		GUIFactory factory = GUIAbstractFactory.createFactory();
		
		Button button = factory.createButton(10, 5);
		
		button.paint();
		button.showSpecs();
		
		CheckBox checkBox = factory.createCheckBox(true);

		checkBox.paint();
		checkBox.showSpecs();
		
	}

}
