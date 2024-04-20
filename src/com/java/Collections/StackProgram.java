package com.java.Collections;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

public class StackProgram {

	public static void main(String[] args) {

		//////////////////// Stack /////////////////////////////////
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i=0; i<10; i++) {
			st.push(i); // normal push for stack
		}
		
		System.out.println("Poppoing out the top most element:" + st.pop() );
		
		System.out.println("The top element of the stack is:" + st.peek() );
		
		System.out.println("Is the top empty? -- "+ st.empty());
		
		// System.out.println("Is the top empty? -- "+ st.isEmpty()); // this works as well.
		
		// st.clear(); // clears the stack
		
		System.out.println("The size of the stack is: "+ st.size());
		
		System.out.println("Element 6 is at the position(from the top considering first element's pos as 1): " + st.search(6) );
		
		System.out.println("Now iterating through the elements of the stack:");
		
		Iterator<Integer> itr = st.iterator(); // The iterator itr points to the element at the bottom of the stack and will traverse from bottom to top
		
		while(itr.hasNext()) {
			Integer x = itr.next();
			System.out.println(x);
		}
		
		
		//////////////////// Stack using ArrayDeque ///////////////////
		ArrayDeque<Integer> adStack = new ArrayDeque<Integer>();
		
		for(int i=0; i<10; i++) {
			adStack.push(i); // push for stack
		}
		
		System.out.println("Poppoing out the top most element:" + adStack.pop() );
		
		System.out.println("The top element of the stack is:" + adStack.peek() );
		
		System.out.println("Is the top empty? -- "+ adStack.isEmpty()); // ArrayDeque has isEmpty() but not empty()
		
		// There is no adStack.search(6) for ArrayDeque
		
		System.out.println("Now iterating through the elements of the stack:");
		
		Iterator<Integer> adItr = adStack.iterator(); // For ArrayDeque, the iterator moves from Top to Bottom.
		
		while(adItr.hasNext()) {
			Integer x = adItr.next();
			System.out.println(x);
		}
		
	}

}
