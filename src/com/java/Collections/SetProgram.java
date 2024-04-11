package com.java.Collections;

import java.util.*;

public class SetProgram {

	public static void main(String[] args) {
		
		//////////////////////////// HashSet //////////////////////////////
		Set<Integer> hashSet = new HashSet<Integer>();
		
		hashSet.add(2);
		hashSet.add(1);
		hashSet.add(3);
		
		for(Integer entry: hashSet) {
			System.out.println(entry);
		}
		
		hashSet.remove(3);
		
		System.out.println("Is the map empty? -- "+ hashSet.isEmpty() );
		hashSet.add(2);
		System.out.println("The size of the map is "+ hashSet.size());
		
		
		//////////////////////// TreeSet ///////////////////////////////////////////
		TreeSet<Integer> treeSet= new TreeSet<Integer>( 
												new Comparator<Integer>(){
													public int compare(Integer a, Integer b) {
														if(a > b)
															return -1;
														if(a < b)
															return 1;
														return 0;
													}
												}
											);
		
		treeSet.add(2);
		treeSet.add(1);
		treeSet.add(5);
		
		for(Integer entry: treeSet) {
			System.out.println(entry);
		}
		
		System.out.println("The floor entry of key 4 is "+ treeSet.floor(4) );
		System.out.println("The ceil entry of key 4 is "+ treeSet.ceiling(4) );
	}

}
