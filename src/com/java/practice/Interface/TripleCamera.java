package com.java.practice.Interface;


// All the methods in an interface has public as its access modifiers
interface Camera{
	void takePic();
	void takeSelfie();
}

// One interface can inherit another interfaces
public interface TripleCamera extends Camera{
	void takeHDPic();
	
	// Private methods are used to implement default methods
	private void checkResolution()	{
		System.out.println("Checking the resolution of the picture.");
	}
	
	default void beautifyPic() {
		checkResolution();
		System.out.println("Your picture is beautified.");
	}
	
}

// The class implementing the interface will have to implement all the methods of Camera and TripleCamera
class dummyPhone implements TripleCamera{

	@Override
	public void takePic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeSelfie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeHDPic() {
		// TODO Auto-generated method stub
		
	}
	
	// Default methods may be overridden in the implementing class but it is not mandatory
	@Override
	public void beautifyPic() {
		
	}	
	
	// Private methods of interface can not be overridden
//	@Override
//	public void checkResolution() {
//		
//	}	
}


