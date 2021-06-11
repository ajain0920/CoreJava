package com.test;

public class Consumer implements Runnable {
	BlockingQueue blockingQueue; 
	
	public Consumer(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			Message msg = null;
			try {
				msg = (Message)blockingQueue.dequeue();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumed Message: " + msg.toString());
		}
		
	}
}
