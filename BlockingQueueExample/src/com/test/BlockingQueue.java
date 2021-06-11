package com.test;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	
	private List queue = new LinkedList();
	private int upperBound;

	public BlockingQueue(int upperBound) {
		this.upperBound = upperBound;
	}
	
	public synchronized void enqueue(Object element) throws InterruptedException {
		while(this.queue.size()==this.upperBound) {
			wait();
		}
		this.queue.add(element);
		if(this.queue.size() == 1) {
			notifyAll();
		}
	}
	
	public synchronized Object dequeue() throws InterruptedException {
		while(this.queue.size() ==0) {
			wait();
		}
		if(this.queue.size() == this.upperBound) {
			notifyAll();
		}
		
		return this.queue.remove(0);
		
	}
	
}
