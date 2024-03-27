package com.java.Collections;

public class ArrayProgram {

	private static void printArray(int arr[]) { // passed by reference
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static void printMat(int mat[][]) {
		int n = mat.length,
			m = mat[0].length;
		
		for(int i=0; i<n ;i++) {
			for(int j=0; j<m; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static int [] getTwoPositiveNumbers(int arr[]) { // function which return Array
		int positiveIntegers[] = new int[2];
		int ind = 0;
		
		for(int x: arr) {
			if(ind>=2)
				break;
			if( x > 0 ) {
				positiveIntegers[ind++] = x;
			}
		}

		return positiveIntegers;
	}
	
	public static void main(String[] args) {
		
		///////////// Array //////////////////////////
		// Declaration
		int initializedArr[] = {1,2,3,4,5,6};
		
		printArray(initializedArr); // Array is passed by reference
		
		int arr[] = new int[10];
		
		for(int i=0; i < arr.length; i++) { // gives the length of the array
			arr[i] = i;
		}
		
		printArray(arr); // Passed by reference

		printArray( new int[]{9, 8, 7} ); // Anonymous array

		printArray( getTwoPositiveNumbers(new int[]{ -1, -2, 0, 1, 4}) );
		
		
		//////////////// Matrix /////////////////////
		
		int mat[][] = { {1,2}, {3,4} };
		
		printMat(mat);

		int jaggedArray[][] = new int[3][]; // Matrix with different lengths of rows
		
		jaggedArray[0] = new int[2];
		jaggedArray[1] = new int[3];
		jaggedArray[2] = new int[4];
	}

}
