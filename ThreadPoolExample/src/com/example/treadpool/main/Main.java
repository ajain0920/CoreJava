package com.example.treadpool.main;

public class Main {
	public static void main(String[] args) {
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 3);
		int i = 0;
		System.out.println("*******Execution Start*****");
		while(i<100) {
			tpe.execute(new MyTask());
			i++;
		}
		
		try { 
			tpe.waitUntilAllTaskFinished(); 
		}finally{ 
			tpe.stop(); 
		}
		
		
		System.out.println("*******Execution Complete*****");
	}

}
