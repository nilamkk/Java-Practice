package com.java.DesignPatterns.StrategyDP;

import java.util.*;

class Process{
	int pid;
	int burstTime;
	int priority;
	
	public Process(int pid, int burstTime, int priority) {
		this.pid = pid;
		this.burstTime = burstTime;
		this.priority = priority;
	}
}

// Context 
class Scheduler{
	protected List<Process> readyQueue;
	private Strategy strategy;
	
	public Scheduler() {
		this.readyQueue = new ArrayList<Process>();
	}
	
	public void addProcess(Process prs) {
		this.readyQueue.add(prs);
	}
	
	public void setStrategy(Strategy stg) {
		this.strategy = stg;
	}
	
	public void scheduleProcess() {
		this.strategy.scheduleProcess(this);
	}
	
}

//Strategy interface
interface Strategy{
	void scheduleProcess(Scheduler shdlr);
}

// Concrete strategy
class ShortestJobFirstStrategy implements Strategy{

	@Override
	public void scheduleProcess(Scheduler shdlr) {
		int shortestJobIndex = -1;
		int shortestBurstTime = Integer.MAX_VALUE;
		
		for(int i=0; i < shdlr.readyQueue.size(); i++) {
			Process prs = shdlr.readyQueue.get(i);
			if( prs.burstTime < shortestBurstTime ) {
				shortestBurstTime = prs.burstTime;
				shortestJobIndex = i;
			}
		}
		
		System.out.println("Scheduling process with pid "+ shdlr.readyQueue.get(shortestJobIndex).pid + " and shortest burst time "+ shdlr.readyQueue.get(shortestJobIndex).burstTime);
		
		shdlr.readyQueue.remove(shortestJobIndex);
	}
	
}

//Concrete strategy
class PrioritytStrategy implements Strategy{

	@Override
	public void scheduleProcess(Scheduler shdlr) {
		int highestPrioIndex = -1;
		int highestPrio = Integer.MIN_VALUE;
		
		for(int i=0; i < shdlr.readyQueue.size(); i++) {
			Process prs = shdlr.readyQueue.get(i);
			if( prs.priority > highestPrio ) {
				highestPrio = prs.priority;
				highestPrioIndex = i;
			}
		}
		
		System.out.println("Scheduling process with pid "+ shdlr.readyQueue.get(highestPrioIndex).pid + " and highest priority "+ shdlr.readyQueue.get(highestPrioIndex).priority);
		
		shdlr.readyQueue.remove(highestPrioIndex);
		
	}
	
}


public class Demo {

	public static void main(String[] args) {
		// Client
		Scheduler schdlr = new Scheduler();
		
		schdlr.addProcess(new Process(1, 23, 5));
		schdlr.addProcess(new Process(2, 27, 2));
		schdlr.addProcess(new Process(3, 21, 7));
		schdlr.addProcess(new Process(4, 29, 1));
		schdlr.addProcess(new Process(5, 22, 9));
		schdlr.addProcess(new Process(6, 26, 10));
		schdlr.addProcess(new Process(7, 10, 4));
		
		schdlr.setStrategy(new PrioritytStrategy());
		
		schdlr.scheduleProcess();
		schdlr.scheduleProcess();
		
		schdlr.setStrategy(new ShortestJobFirstStrategy());
		
		schdlr.scheduleProcess();
		schdlr.scheduleProcess();
		
		
	}

}
