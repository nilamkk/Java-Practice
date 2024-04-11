package com.java.Collections;

import java.util.*;

public class JavaMaps {

	public static void main(String[] args) {
		
		///////////////////////// HashMap /////////////////////////////////////
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(2, "The Lost Symbol");
		hashMap.put(1, "IKIGAI");
		hashMap.put(3, "The Ride of a Life Time");
		
		for(Map.Entry<Integer, String> entry: hashMap.entrySet()) {
			System.out.println(entry);
		}
		
		hashMap.remove(3);
		
		System.out.println("Is the map empty? -- "+ hashMap.isEmpty() );
		hashMap.put(2, "Atomic Habits");
		System.out.println("The size of the map is "+ hashMap.size());
		
		
		//////////////////////// TreeMap ///////////////////////////////////////////
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		treeMap.put(2, "The Lost Symbol");
		treeMap.put(1, "IKIGAI");
		treeMap.put(5, "The Ride of a Life Time");
		
		for(Map.Entry<Integer, String> entry: treeMap.entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println("The floor entry of key 4 is "+ treeMap.floorEntry(4) );
		System.out.println("The ceil entry of key 4 is "+ treeMap.ceilingEntry(4) );
		
		
		
	}

}
