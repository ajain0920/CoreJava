package com.example.collection.main;

import java.util.stream.IntStream;

public class ReversedLinkedListExample {

	
	public static void main(String[] args) {
		
		MyLinkedList<Integer> myList = new MyLinkedList<Integer>();
		IntStream.rangeClosed(1,10).forEach(e -> myList.add(e));
		myList.printList();
		System.out.println("Node Head: " + myList.getHead());
		myList.printInReverse();
	}

	

}
