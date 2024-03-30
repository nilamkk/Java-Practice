package com.java.Collections;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeProgram {

	public static void main(String[] args) {
		
		//////////////////////////// ArrayDeque ///////////////////////////////
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		
		dq.add(1);
		dq.addFirst(2);
		dq.addLast(3);
		
		dq.offer(4);
		dq.offerFirst(5);
		dq.offerLast(6);		
		
		dq.push(7);
		
		// Forward iteration
		System.out.println("Forward iteration");
		for(Iterator<Integer> itr = dq.iterator(); itr.hasNext(); ) {
			System.out.print( itr.next() + " ");
		}
		System.out.println();
		
		System.out.println( dq.getFirst() );
		System.out.println(dq.getLast());
		System.out.println(dq.peekFirst());
		System.out.println(dq.peekLast());
		
		System.out.println(dq.peek());

		
		// Backward iteration
		System.out.println("Backward iteration");
		for(Iterator<Integer> itr = dq.descendingIterator(); itr.hasNext(); ) {
			System.out.println( itr.next() );
		}
		System.out.println();
		
		
		dq.remove();
		dq.removeFirst();
		dq.removeLast();
		
		dq.poll();
		dq.pollFirst();
		dq.pollLast();		
		
		dq.pop();
		
		System.out.println("Is the deque empty? -- "+ dq.isEmpty());
		
		
		

	}

}
