package com.test.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintThreadInSyncTask implements Runnable {
	private static Object lock = new Object();
	private final int remainder;
	private static AtomicInteger i = new AtomicInteger();
	
	public PrintThreadInSyncTask(int remainder) {
		this.remainder = remainder;
		i.set(1);
	}
	
	
	@Override
	public void run() {
		while(i.get()<100) {
			synchronized (lock) {
				while(Math.floorMod(i.get(), 3) != remainder){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(i.getAndIncrement() + " : " + Thread.currentThread());
				lock.notifyAll();
			}
		}
	}

}
