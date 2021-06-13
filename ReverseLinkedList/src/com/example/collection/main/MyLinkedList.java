package com.example.collection.main;

/*
 * Singly linked list implementation using only one pointer next in node. 
 * Head node will point to the first element added. 
 * Added a method to reverse the linked list by passing current head node and 
 * it will return the new head pointing to last element of original list.
 * One can also print the list/reversed list
 * */
public class MyLinkedList<E> {
	//Head points to first element of the list
	private Node<E> head;
	
	private class Node<E>{
		private E e;
		private Node next;
		
		Node(E e, Node next){
			this.e = e;
			this.next = next;
		}
	}
	
	public E getHead() {
		return head!=null? head.e : null;
	}
	
	public void add(E e) {
		Node<E> new_node = new Node(e, null);
		if(head==null) {
			head = new_node;
		}else {
			Node lastNode = head;
			//iterate to find last element and add
			while(lastNode.next!=null) {
				 lastNode = lastNode.next;
				 
			}
			lastNode.next = new_node;
		}
	}
	
	public void printList() {
		this.printList(this.head);
	}
	public void printList(Node head) {
		Node currentNode = head;
		while(currentNode!=null) {
			System.out.println(currentNode.e);
			currentNode = currentNode.next;
		}
	}
	
	public void printInReverse() {
		Node<E> localReversedHead = this.head;
		localReversedHead = reverse(localReversedHead);
		while(localReversedHead!=null) {
			System.out.println(localReversedHead.e);
			localReversedHead = localReversedHead.next;
		}
	}

	private MyLinkedList<E>.Node<E> reverse(Node<E> head) {
		if(head == null) {
			return head;
		}
		
		if(head.next == null) {
			return head;
		}
		Node lastHead = reverse(head.next); //Always return only last element as head. Eventually the final result of this methid will be the last element.
		head.next.next = head; // Only head(in this loop will act as previous node) will change per iteration and the current node is update to point previous node.
		head.next = null; // Also the next pointer of previous node is update to point to null; making it last element of list.
		
		return lastHead;
	}
	

	
}
