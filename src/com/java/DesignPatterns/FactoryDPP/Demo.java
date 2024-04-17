package com.java.DesignPatterns.FactoryDPP;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Team{
	protected ArrayList<String> players;
	
	public Team() {
		this.players = new ArrayList<String>();
		this.createTeam();
	}
	
	public abstract void createTeam();
	
	public void showPlayers() {
		System.out.println("The players are: " + this.players );
	}
}

class India extends Team{
	@Override
	public void createTeam() {
		String [] players = { "Dhoni", "Yuvraj", "Bumrah", "Jadeja" };
		
		for( String player: players) {
			this.players.add(player);
		}
	}	
}

class England extends Team{
	@Override
	public void createTeam() {
		String [] players = { "Root", "Ben Stokes", "Pope", "Tom" };
		
		for( String player: players) {
			this.players.add(player);
		}
	}
}


class TeamFactory{
	public static Team getTeam(String teamName) {
		if( teamName.equals("India") ) {
			return new India();
		}else if( teamName.equals("England") ) {
			return new England();
		}
		return null;
	}
}

public class Demo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tell me the team you want to build: ");
		String teamName = scanner.next();
		
		Team myTeam = TeamFactory.getTeam(teamName);
		
		if(myTeam == null) {
			System.out.println("Selected team is not available!");
			return;
		}
		
		myTeam.showPlayers();	
		
		scanner.close();
	}

}
