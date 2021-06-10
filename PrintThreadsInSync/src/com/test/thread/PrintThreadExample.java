package com.test.thread;

public class PrintThreadExample {
	
	public static void main(String[] args) {
		PrintThreadInSyncTask task1 = new PrintThreadInSyncTask(1%3);
		PrintThreadInSyncTask task2 = new PrintThreadInSyncTask(2%3);
		PrintThreadInSyncTask task3 = new PrintThreadInSyncTask(3%3);
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

	
}
