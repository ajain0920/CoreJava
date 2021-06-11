package com.example.executors.main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Callable c = () -> {
			System.out.println("Running task!");
			Thread.sleep(1000);
			System.out.println("Still Running the task!");
			Thread.sleep(1000);
			System.out.println("Task Complete!");
			return "success";
		};
		Future<String> future1 = executorService.submit(c);
		
		try {
			System.out.println("Checking response!");
			String result = future1.get();  //? does it move the current thread in wait? -- Yes
			System.out.println("Checking complete!");
			System.out.println("Result: " + result);
		} catch (ExecutionException e) {
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}

}
