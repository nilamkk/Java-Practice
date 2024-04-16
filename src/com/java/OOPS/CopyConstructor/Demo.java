package com.java.OOPS.CopyConstructor;

class Rosogulla{
	
	private final String rSize;
	private int rSweetness;
	
	public Rosogulla(String pSize, int pSweetness) {
		this.rSize = pSize;
		this.rSweetness = pSweetness;
	}
	
	public Rosogulla(Rosogulla pRosogulla) {
		this.rSize = pRosogulla.rSize;
		this.rSweetness = pRosogulla.rSweetness;
	}
	
	public void showAttributes() {
		System.out.println("Size -- "+ rSize);
		System.out.println("Sweetness -- "+ rSweetness);
	}
	
}

public class Demo {

	public static void main(String[] args) {

		Rosogulla ros = new Rosogulla("Small", 5);
		
		Rosogulla copyRos = new Rosogulla(ros);

		ros.showAttributes();
		copyRos.showAttributes();
		
	}

}
