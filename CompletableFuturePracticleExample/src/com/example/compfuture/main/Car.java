package com.example.compfuture.main;

public class Car {
	
	int manufactureId;
	String model;
	int rating;
	
	public Car(String model, int manufactureId) {
		this.model = model;
		this.manufactureId = manufactureId;
		System.out.println("Car Created : " + toString() + " : " +Thread.currentThread());
	}

	
	@Override
	public String toString() {
		return "Car [manufactureId=" + manufactureId + ", model=" + model + "]";
	}


	public Integer getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
