package com.ashish.linkedList.problems;

public class LinkedList {
	Node head;
	Node trail;
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		linkedList.add2FirstToCircular(10);
		linkedList.add2FirstToCircular(20);
		linkedList.add2FirstToCircular(30);
		linkedList.add2FirstToCircular(40);
		linkedList.add2FirstToCircular(50);
		//linkedList.add2FirstToCircular(60);
		//linkedList.add2FirstToCircular(70);
		linkedList.displayCircularList();
		linkedList.getLoopFirstNode();
		linkedList.getLengthOfLoop();






		/*linkedList.addToFirst(1);
		linkedList.addToFirst(2);
		linkedList.addToFirst(3);
		linkedList.addToFirst(4);
		linkedList.addToFirst(5);
		linkedList.addToFirst(6);
		linkedList.display();
		System.out.println("Result : "+linkedList.listIsCircular());
		linkedList.nthNodeFormEnd(3); */  
	}

	private boolean listIsCircular(){
		Node slow = head;
		Node fast = head;

		while(fast != null || fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();

			if(fast == slow) return true;
			if(fast == null) return false;
		}

		return false;
	}

	public void getLengthOfLoop(){
		Node slow = head;
		Node fast = head;
		boolean isLoop = false;

		while(fast != null || fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if(slow == fast) {
				isLoop = true;
				break;
			}

			if(fast == null)break;
		}
		int count  = 0;
		if(isLoop){
			count++;
			fast = fast.getNext();
			while(fast != slow){
				++count;
				fast = fast.getNext();
			}
		}else{
			System.out.println("Linked List is not loop");
		}
		if(count != 0){
			System.out.println("Length of Loop is : "+count);
		}



	}

	private void getLoopFirstNode(){
		Node slow = head;
		Node fast = head;
		boolean isLoop = false;

		while(fast != null || fast.getNext() != null) {
			slow  = slow.getNext();
			fast = fast.getNext().getNext();

			if(fast == slow) {
				isLoop = true;
				break;
			}
			if(fast == null) break;
		}
		if(isLoop){
			slow = head;
			while(slow != fast){
				slow = slow.getNext();
				fast = fast.getNext();
			}
		}
		System.out.println("--->"+slow.getData()+"......");

	}


	private void addToFirst(int data){
		Node newNode = new Node(data);
		if(head == null ){
			head = newNode;
		}else{
			newNode.setNext(head);
			head = newNode;
		}
	}

	private void add2FirstToCircular(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			trail = node;
			trail.setNext(node);
		}else if(trail == null){
			trail = node;
			trail.setNext(node);
		}else{
			node.setNext(head);
			head= node;
			trail.setNext(head);
		}
	}

	private int nthNodeFormEnd(int n){
		Node current = head;
		Node forward = head;

		int temp = 1;
		while(temp++ <= n){
			forward = forward.getNext();
		}	
		while(forward != null){
			current = current.getNext();
			forward = forward.getNext();
		}
		System.out.println(n+" th Node from End : "+current.getData());

		return current.getData();
	}

	private void displayCircularList(){
		Node temp = head;

		if(temp == null) {
			System.out.println("List is empty................");
			return;
		}
		System.out.println("Displaying Circular................");

		do{
			System.out.println(temp.getData());
			temp = temp.getNext();
		} while(temp != null && temp != head);


	}

	private void display(){
		Node temp = head;
		System.out.println("Displaying.................");
		if(temp != null){
			while(temp != null){
				System.out.println(""+temp.getData());
				temp = temp.getNext();
			}
		}else{
			System.out.println("List is nulll");

		}
	}

}
