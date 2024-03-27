package com.java.Collections.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


// Comparator for sorting in descending order
class DescCompare implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 == o2)
			return 0; // means both the elements have same values 
		if(o1>o2) 
			return -1; // means the pair should not swapped
		return 1; // means the pair should be swapped
	}	
}


public class ArrayListProgram {

	public static void main(String[] args) {
		
		ArrayList<Integer> emptyArr = new ArrayList<Integer>(); // Empty array
		ArrayList<Integer> emptArr1 = new ArrayList<Integer>(10); // Array with capacity not size -- 
		// The difference is that size is the number of elements contained and capacity is the maximum number of elements
		
		emptyArr.add(200); // will add the element at the end of the array
		// emptArr1.add(1, 100); // not possible since the array is still empty
		
		System.out.println(emptyArr); // Will print the array
		System.out.println(emptArr1);
		
		
		for(int i=0; i< 10; i++) {
			emptArr1.add(i,i); // will add the element at the specified index
			// Ideally arr.add(i, x) --> It will add the element at the specified position of the array and will shift rest of the array
			// So if the array is [1,2] then add() is possible with input index 0, 1, 2 but not 3 and onwards.
		}
		
		emptArr1.set(0, 1000); // sets the specified index with the provided value
		
		System.out.println("After adding 10 elements:");
		System.out.println(emptArr1);
		
		System.out.println("Returns the number of elements in the array:");
		System.out.println(emptArr1.size());
		
		System.out.println("Get element at a particular position (3) of the array:");
		System.out.println(emptArr1.get(3));
		
		Collections.sort(emptArr1, new DescCompare());
		System.out.println("After sorting the array in descending order:");
		System.out.println(emptArr1);
		
		emptArr1.clear(); // clears the list
		
		System.out.println("After emptArr1.clear():");
		System.out.println(emptArr1);
		
		System.out.println("Checks if the array is empty:");
		System.out.println(emptArr1.isEmpty());
		
		
		
		
		for(int i=0; i< 10; i++) {
			emptArr1.add(i,i); // will add the element at the specified index
		}
		
		// Iterating array with iterator
		Iterator<Integer> itr = emptArr1.iterator(); // returns the iterator
		// checks if the next element is present
		while(itr.hasNext()) {
			System.out.print(itr.next()); // returns the iterator and moves to the next element
		}
		System.out.println();
		
		// Iterating ArrayList using For-each loop
		for(Integer x:emptArr1) {
			System.out.print(x);
		}
		
	}

}
