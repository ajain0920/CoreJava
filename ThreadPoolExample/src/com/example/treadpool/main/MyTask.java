package com.example.treadpool.main;

import java.util.concurrent.atomic.AtomicInteger;

public class MyTask implements Runnable {
	private static AtomicInteger count = new AtomicInteger(0);
	private final int taskNum;
	
	public MyTask() {
		System.out.println("Task:" + count.incrementAndGet() + " created");
		this.taskNum = count.get();
	}
	
	@Override
	public void run() {
		System.out.println("Task:" + this.taskNum + " is running");
	}

}
