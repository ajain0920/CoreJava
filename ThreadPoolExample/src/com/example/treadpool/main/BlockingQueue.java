package com.example.treadpool.main;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue <T> {
	List<T> queue = new LinkedList<T>();
	int count = 0;
	int limit = 0;
	
	public BlockingQueue(int limit) {
		this.limit = limit;
	}
	
	public int getSize() {
		return this.queue.size();
	}

	public synchronized void enqueue(T element) throws InterruptedException{
		while(this.queue.size() == this.limit) {
			wait();
		}
		
		queue.add(element);
		if(this.queue.size() == 1) {
			notifyAll();
		}
	}
	
	public synchronized T dequeue() throws InterruptedException{
		while(this.queue.size() == 0) {
			wait();
		}
		
		if(this.queue.size()==this.limit) {
			notifyAll();
		}
		return queue.remove(0);
	}
}
