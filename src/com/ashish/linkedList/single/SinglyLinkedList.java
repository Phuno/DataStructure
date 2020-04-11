package com.ashish.linkedList.single;


public class SinglyLinkedList {

	Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.head = new Node(10);
		
		
		
		linkedList.push(20);
		linkedList.push(30);
		linkedList.push(40);
		linkedList.print();
		linkedList.pushAtLast(23);
		

	}
	
	public void push(int data){
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	public void pushAtLast(int data){
		System.out.println("****************************");
		Node node = head;
		Node temp = null;
		while(node != null){
			temp = node;
			node = node.next;
		}
		Node node1 = new Node(data);
		temp.next = node1;
		print();
	}
	
	
	public void print(){
		Node node = head;
		
		while(node!=null){
			System.out.println("Value is : "+node.data);
			node = node.next;
		}
	}
	
	

}
