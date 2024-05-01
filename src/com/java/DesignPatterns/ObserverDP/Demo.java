package com.java.DesignPatterns.ObserverDP;

import java.util.*;

interface Subscriber{
	void notify(String channel);
}

// Observer 
class User implements Subscriber{
	private int id;

	public User(int pId) {
		this.id = pId;
	}
	
	@Override
	public void notify(String channel) {
		System.out.println("Id-"+ this.id+ ": "+channel + " has posted a new video!");
	}

	public int getId() {
		return id;
	}
}

// Subject/ publisher
class YoutubeLite {
	private Map<String, List<Subscriber>> channelSubscribersMap;
	
	public YoutubeLite() {
		this.channelSubscribersMap = new HashMap<String, List<Subscriber>>();
	}
	
	public void addSubscriber(String channel, Subscriber subscriber) {
		if(!this.channelSubscribersMap.containsKey(channel)) {
			this.channelSubscribersMap.put(channel, new ArrayList<Subscriber>() );
		}
		this.channelSubscribersMap.get(channel).add(subscriber);
	}
	
	public void removeSubscriber(String channel, Subscriber subscriber) {
		if(this.channelSubscribersMap.containsKey(channel)) {
			this.channelSubscribersMap.get(channel).remove(subscriber);
		}
	}
	
	public void addVideo(String channel) {
		// Add the video 
		// Send notification to all subscribers
		for(Subscriber subscriber : this.channelSubscribersMap.get(channel) ) 
			subscriber.notify(channel);
	}
	
}

public class Demo {

	public static void main(String[] args) {
		
		YoutubeLite ytLite = new YoutubeLite();
		
		Subscriber nilam = new User(1);
		Subscriber shan = new User(2);
		Subscriber kuldip = new User(3);
		
		ytLite.addSubscriber("OJ", nilam);
		ytLite.addSubscriber("OJ", shan);
		ytLite.addSubscriber("OJ", kuldip);

		ytLite.addVideo("OJ");
		
		ytLite.addSubscriber("Slayy Point", kuldip);
		ytLite.addSubscriber("Slayy Point", nilam);

		ytLite.addVideo("Slayy Point");
		
		ytLite.removeSubscriber("OJ", kuldip);
		
		ytLite.addVideo("OJ");
		
	}

}
