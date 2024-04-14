package com.java.DesignPatterns.BuilderDP.URLBuilder;

public class Demo {

	public static void main(String[] args) {

		URLBuilder.Builder builder = new URLBuilder.Builder();
		
		URLBuilder urlBuilder = builder
							.protocol("https://")
							.hostname("www.youtube.com")
							.pathParam("/watch")
							.queryParam("?v=4ff_KZdvJn8")
							.build();
		
		System.out.println("The url is - "+ urlBuilder.getURL() );
		
	}

}
