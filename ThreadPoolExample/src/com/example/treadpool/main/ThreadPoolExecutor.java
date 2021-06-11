package com.example.treadpool.main;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolExecutor {
	private final BlockingQueue<Runnable> queue;
	private final int MAX_THREADS = 10;
	private int noOfThreads = 0;
	private final List<Thread> threads;
	private boolean stop = false;
	
	public ThreadPoolExecutor(int queue_size, int noOfThreads) {
		this.queue = new BlockingQueue<Runnable>(queue_size);
		this.noOfThreads = Math.min(noOfThreads, MAX_THREADS);
		this.threads = new ArrayList<Thread>(MAX_THREADS);
		for(int i = 0; i < this.noOfThreads; i++) {
			threads.add(new Thread(
					() -> {
						while(!this.stop) {
							try {
							Runnable task = this.queue.dequeue();
							System.out.println(Thread.currentThread().toString() + " picked the task to run");
							//new Thread(task).start();
							task.run();
							}catch(InterruptedException ex) {
								this.stop = true;
							}
						}
					}
					));
		}
		for(Thread th : threads) {
			th.start();
		}
	}
	
	public void execute(Runnable task){
		try{
			this.queue.enqueue(task);
			
		}catch(InterruptedException ex) {
			this.stop = true;
		}
	}

	public void stop() {
		while(this.queue.getSize()!=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		stopImmediately();
	}
	
	public void stopImmediately() {
		for(Thread th : threads) {
			try {
				System.out.println("Stopping Thread: " + th.getName());
			}
			finally {
				th.interrupt();
			}
		}
	}
	
	public void waitUntilAllTaskFinished() {
		while(this.queue.getSize() > 0 ) {
			try {
				Thread.sleep(1);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
