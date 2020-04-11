package com.ashish.linkedList.circular;

import com.ashish.linkedList.single.Node;

public class CircularLinkedList {

	Node head;
	Node trail;



	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();

		circularLinkedList.addNodeAtFirst(20);
		//circularLinkedList.addNodeAtFirst(10);
		//circularLinkedList.addNodeAtFirst(30);
		circularLinkedList.print();
	}

	public void print(){
		Node current = head;
		if(current == null){
			System.out.println("List is empty");
		}else {

			do{
				System.out.println(""+current.getData());
				current = current.getNext();
			}while(current != head);{

				System.out.println("done");  
			}
		}

	}

	public void addNodeAtFirst(int data){


		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			trail = newNode;
			newNode.setNext(head);
		} else {

			newNode.setNext(head);
			head = newNode;
			trail.setNext(head);
		}


	}
}
