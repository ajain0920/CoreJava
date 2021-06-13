package com.example.compfuture.main;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
		
	public static int rating(int manufacturerId) {
		
		return 1;
	}
	
	private static List<CompletableFuture<Car>> getCars(){
		List<Integer> range = IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
		return range.stream().map(count -> CompletableFuture.supplyAsync(CarProducer::produce)).collect(Collectors.toList());
	}
	
	/*
	 * private static List<Car> rateCars(){ List<Integer> range =
	 * IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList()); return
	 * range.stream().map(count ->
	 * CarProducer.produce(count)).collect(Collectors.toList()); }
	 */
	

	public static void main(String[] args) {
		//Task1. •First fetch a list of Car objects asynchronously by calling the cars() method, which returns a CompletionStage. The cars() method could be consuming a remote REST endpoint behind the scenes.
		
		//Task2. •We then compose another CompletionStage that takes care of filling the rating of each car, by calling the rating(manufacturerId) method which returns a CompletionStage that asynchronously fetches the car rating (again could be consuming a REST endpoint).
		
		//Task3 •When all Car objects are filled with their rating, we end up with a List, so we call allOf() to get a final stage (stored in variable done) that completes upon completion of all these stages.
		
		//Task4 •Using whenComplete() on the final stage, we print the Car objects with their rating.
		
		/***********************************/
		//1. Get Cars list and map each car with a computable future 
		AtomicInteger count = new AtomicInteger(0);
		List<CompletableFuture<Car>> cars = getCars();
		List<CompletableFuture<Car>> futures = cars.stream().map(future -> future.thenApplyAsync(CarRating::rateCar))
				.collect(Collectors.toList());
		
		CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
				.whenComplete((v, th) -> {
					futures.forEach(cf -> {
						Car car = cf.getNow(null);
						if(car!=null) {
							System.out.println(car + " | [Rating: " + car.getRating() + "] " + Thread.currentThread());
						}
						count.incrementAndGet();
					});
				});
		
		allOf.join();
		System.out.println("Completed processing of " + count.get() + " no. of cars!");
		/***********************************/

		
	}

}
