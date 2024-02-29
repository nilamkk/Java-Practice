package com.java.practice.Interface;

interface GPS{
	void GetLocation();
}

interface WIFI{
	void getConnection();
}

class CellPhone{
	
	public void callNumber(String Number) {
		System.out.println("Calling the number " + Number );
	}
	
	public void pickPhone() {
		System.out.println("Picking up the phone...");
	}
	
}

class SmartPhone extends CellPhone implements GPS, WIFI, TripleCamera{

	@Override
	public void takePic() {
		System.out.println("Taking pic...");
	}

	@Override
	public void takeSelfie() {
		System.out.println("Taking selfie...");
	}

	@Override
	public void takeHDPic() {
		System.out.println("Taking HD pic...");
	}

	@Override
	public void getConnection() {
		System.out.println("Getting you a connection...");
	}

	@Override
	public void GetLocation() {
		System.out.println("Getting you the exact location...");
	}
	
}


public class MySmartPhone {

	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone();
		
		// All methods can be accessed
		smartPhone.callNumber("9876543210"); // CellPhone's method
		smartPhone.pickPhone(); // CellPhone's method
		
		smartPhone.GetLocation(); // GPS methods
		smartPhone.getConnection(); // WIFI methods
		
		smartPhone.takePic(); // Camera method
		smartPhone.takeSelfie(); // Camera method
		smartPhone.takeHDPic(); // TripleCamera method
		
		// Polymorphism in interface example
		GPS gpsPhone = new SmartPhone();
		
		gpsPhone.GetLocation(); // It can only access methods from GPS interface coz the reference is of GPS interface
		// gpsPhone.getConnection(); // It can't access other methods
		
		CellPhone cellPhone  = new SmartPhone();
		
		cellPhone.pickPhone(); // Allowed
		// cellPhone.getLocation(); // Not allowed
		
	}

}
