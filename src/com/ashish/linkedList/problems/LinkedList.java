package com.ashish.linkedList.problems;

public class LinkedList {
	static Node head;
	Node trail;
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		/*linkedList.add2FirstToCircular(10);
		linkedList.add2FirstToCircular(20);
		linkedList.add2FirstToCircular(30);
		linkedList.add2FirstToCircular(40);
		linkedList.add2FirstToCircular(50);
		linkedList.add2FirstToCircular(60);
		linkedList.add2FirstToCircular(70);
		linkedList.displayCircularList();
		linkedList.getLoopFirstNode();
		linkedList.getLengthOfLoop();*/






		linkedList.addToFirst(61);
		linkedList.addToFirst(51);
		linkedList.addToFirst(41);
		linkedList.addToFirst(31);
		linkedList.addToFirst(21);
		linkedList.addToFirst(11);
		//linkedList.insertInShortedLinkedList(77);
		linkedList.display();
		linkedList.reverseRecursion(head);
			
		linkedList.display();
		
		
		//System.out.println("List is circular : "+linkedList.listIsCircular());
		//linkedList.nthNodeFormEnd(3);   
	}
	
	private void reverseRecursion(Node current){
		
		
		if(current.getNext() == null){
			head = current;
			return;
		}
		reverseRecursion(current.getNext());
		Node next = current.getNext();
		next.setNext(current);
		current.setNext(null);
		
	}
	
	private void reverseLinkedList(){
		Node prev = null, next = null;
		Node current = head;
		
		while(current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;		
		}
		
		head = prev;
		
		display();
	}
	
	
	
	
	
	private void insertInShortedLinkedList(int data){
		Node node = new Node(data);
			Node temp = null;
			Node current = head;
		if(head != null){
			
			while(current != null && data > current.getData()){
				temp = current;
				current = current.getNext();
				//System.out.println("Datta : "+current.getData());
			}
			
			node.setNext(current);
			temp.setNext(node);
			
			
		}else{
			System.out.println("List is empty");
		}
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

		int temp = 0;
		while(temp++ < n){
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
