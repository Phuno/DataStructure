
package com.ashish.linkedList.doubley;

public class MainDoubleLinkedList {
	
	Node head;
	public static void main(String[] args) {
		MainDoubleLinkedList linkedList = new MainDoubleLinkedList();
		linkedList.head = new Node(10);
		
		linkedList.addFirst(20);
		linkedList.addLast(30);
		linkedList.addLast(40);
		linkedList.addFirst(2);
		linkedList.printAll();
		linkedList.deleteLast();
		linkedList.deleteFirst();
		

	}
	
	public void addAtMiddle(int data){
		  
	}
	
	
	
	public void deleteFirst(){
		System.out.println("DELETE............FIRST");

		head = head.getNext();
		head.setPrev(null);
		printAll();
	}
	
	public void deleteLast(){
		System.out.println("DELETE............LAST");
		Node temp = head;
		Node prev = head;
		while(temp.getNext() != null){
			prev = temp;
			temp = temp.getNext();
		}
		
		prev.setNext(null);
		printAll();
		
	}
	
	public void addLast(int data){
		Node node = new Node(data);
		Node temp = head;
				
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		
		temp.setNext(node);
		node.setPrev(temp);		
	}
	
	public void addFirst(int data){
		
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node node = new Node(data);
		
		head.setPrev(node);
		node.setNext(head);
		head = node;
		
	}
	
	public void printAll(){
		if(head == null) return;
		Node temp = head;
		
		while(temp != null){
			System.out.println("Data is : "+temp.getData());
			temp = temp.getNext();
		}
	}

}
