package com.test;

public class Main {

	public static void main(String[] args) {
		BlockingQueue myBlockingQueue = new BlockingQueue(5);
		
		Thread thread1 = new Thread(new Producer(myBlockingQueue));
		Thread thread2 = new Thread(new Consumer(myBlockingQueue));
		
		thread1.start();
		thread2.start();

	}

}
