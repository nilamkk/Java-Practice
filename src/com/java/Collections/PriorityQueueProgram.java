package com.java.Collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


class Book implements Comparable<Book>{

	int id;
	int numberOfPages;
	String Name;
	String Author;
	
	public Book(int id, int numberOfPages, String Name, String Author){
		this.id = id;
		this.numberOfPages = numberOfPages;
		this.Name = Name;
		this.Author = Author;
	}
	
	@Override
	public int compareTo(Book o) {
		if( numberOfPages > o.numberOfPages )
			return -1;
		if( numberOfPages < o.numberOfPages )
			return 1;
		return 0;
	}
}


public class PriorityQueueProgram {

	public static void main(String[] args) {
		
		/////////////////// Normal Minimum Priority Queue /////////////////
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(); 
		
		minPQ.add(10);		
		minPQ.add(9);
		minPQ.add(8);
		minPQ.add(5);
		minPQ.add(3);
		minPQ.add(1);
		
		System.out.println("The element at the top of the PQ is: " + minPQ.peek() );
		
		
		/////////////////// Maximum Priority Queue /////////////////
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>( Collections.reverseOrder() ); 
		
		maxPQ.add(10);		
		maxPQ.add(9);
		maxPQ.add(8);
		maxPQ.add(5);
		maxPQ.add(3);
		maxPQ.add(1);
		
		System.out.println("The element at the top of the PQ is: " + maxPQ.peek() );
		
		/////////////////// Maximum Priority Queue /////////////////
		PriorityQueue<Integer> maxPQComp = new PriorityQueue<Integer>(
											new Comparator<Integer>() {
												public int compare(Integer x, Integer y) {
													if( x > y )
														return -1;
													if( x < y )
														return 1;
													return 0;
												}
										   }); 
		
		maxPQComp.add(10);		
		maxPQComp.add(9);
		maxPQComp.add(8);
		maxPQComp.add(5);
		maxPQComp.add(3);
		maxPQComp.add(1);
		
		System.out.println("The element at the top of the PQ is: " + maxPQComp.peek() );
		
		
		/////////////////// Maximum Priority Queue /////////////////
		PriorityQueue<Integer> maxPQLamb = new PriorityQueue<Integer>(
											new Comparator<Integer>() {
												public int compare(Integer x, Integer y) {
													if( x > y )
														return -1;
													if( x < y )
														return 1;
													return 0;
												}
										   }); 
		
		maxPQLamb.add(10);		
		maxPQLamb.add(9);
		maxPQLamb.add(8);
		maxPQLamb.add(5);
		maxPQLamb.add(3);
		maxPQLamb.add(1);
		
		System.out.println("The element at the top of the PQ is: " + maxPQLamb.peek() );
		
		
		
		/////////////////// Iterating through the elements of the PQ //////////////////
		for(Integer x: maxPQ) {
			System.out.print(x + " " );
		}
		System.out.println();
		
		
		///////////////////// Priority Queue with Custom Object ////////////////////////
		PriorityQueue<Book> bookPQ = new PriorityQueue<Book>();
		
		bookPQ.add( new Book(1, 208, "IKIGAI", "Francesc and Hector") );
		bookPQ.add( new Book(2, 528, "The Lost Symbol", "Dan Brown") ); 
		bookPQ.add( new Book(3, 272, "The Ride of a Lifetime", "Robert Iger") );
		bookPQ.add( new Book(4, 256, "The Psycology of Money", "Morgan Housel") );
		
		System.out.println("The book with maximum number of pages is: " + bookPQ.peek().Name );

	}

}
