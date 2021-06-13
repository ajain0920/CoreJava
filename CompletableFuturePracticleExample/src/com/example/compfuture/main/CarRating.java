package com.example.compfuture.main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRating {
	static List<Integer> ratings = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
	
	public static Car rateCar(Car car){
		int rank = 0;
		Integer manufacturerId = car.getManufactureId();
		if(manufacturerId == null || manufacturerId == 66) {
			//throw new InvalidCarException("Invalid Car Manufacturer");
		}
		if(car.getManufactureId() == null) {
			rank = ratings.get(ratings.size()-1);
		}else if(car.getManufactureId()%3 ==0) {
			rank = ratings.get(2);
		}else if(car.getManufactureId()%2 ==0) {
			rank = ratings.get(1);
		}else {
			rank = ratings.get(0);
		}
		car.setRating(rank);
		System.out.println("Car Rated: " + car.toString() + " " + Thread.currentThread());
		return car;
	}
}
