package com.java.HelloWorld;


import java.util.*;
import java.io.*;

public class Main {
	
	private static void solve1() {
		// https://codeforces.com/problemset/problem/231/A
		//		3  --> n
		//		1 1 0
		//		1 1 1
		//		1 0 0

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt( sc.nextLine() );
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(String x: sc.nextLine().split(" ")) {
				cnt += Integer.parseInt( x );
			}
			if( cnt >= 2 ) {
				ans++;
			}
		}
		
		System.out.println( ans );
		sc.close();
	}
	
	private static void solve2() throws IOException  {
		// https://codeforces.com/problemset/problem/231/A
		//		3  --> n
		//		1 1 0
		//		1 1 1
		//		1 0 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		
		int n = Integer.parseInt( br.readLine() );
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(String x: br.readLine().split(" ")) {
				cnt += Integer.parseInt( x );
			}
			if( cnt >= 2 ) {
				ans++;
			}
		}
		
		System.out.println( ans );

	}
	
	public static void main(String[] args) throws IOException  {
//		solve1();

		solve2();			
		

	}

}
