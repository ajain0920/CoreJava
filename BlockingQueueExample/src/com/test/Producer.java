package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	BlockingQueue blockingQueue;
	private AtomicInteger count = new AtomicInteger();
	
	public Producer(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
		this.count.set(0);
	}

	@Override
	public void run() {
		//repeat
		while(this.count.get() < 100) {
			//enter lock - not required. Handled inside blocking queue
			//critical piece of code
			//create message
			Message msg = new Message("Hello Message No. " + this.count.incrementAndGet()); 
			// enque in blockingqueue
			try {
				blockingQueue.enqueue(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produced Message: " + msg.toString());
			//critical piece of code ends
			//release lock. Not required. Handled inside blocking queue
		}
	}
	
	

}
