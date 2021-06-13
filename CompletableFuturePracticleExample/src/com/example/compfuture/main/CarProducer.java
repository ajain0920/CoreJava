package com.example.compfuture.main;

import java.util.concurrent.atomic.AtomicInteger;

public class CarProducer{
	private static AtomicInteger count = new AtomicInteger();
		
	public static Car produce(){
		return new Car("Car"+(count.getAndIncrement()), ((count.get())%10)+1);
	}

}
