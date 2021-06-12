package com.example.compfuture.main;

import java.util.concurrent.CompletableFuture;

public class Main {
	
	public static int compute() {
		System.out.println("compute: "+ Thread.currentThread());
		return 2;
	}
	
	public static void printIt(int d) {
		System.out.println("print: "+ Thread.currentThread());
		System.out.println(d);
	}
	
	public static CompletableFuture<Integer> create(){
		return CompletableFuture.supplyAsync(() -> compute());		
	}
	

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main: "+ Thread.currentThread());
		create().thenAccept(data -> printIt(data));
		
		Thread.sleep(1000);
		
	}

}
