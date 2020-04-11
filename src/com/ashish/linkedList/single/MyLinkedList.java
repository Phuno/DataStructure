package com.ashish.linkedList.single;



public class MyLinkedList {


	Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.head = new Node(10);
		linkedList.addAtFirst(20);
		linkedList.addAtFirst(30);

		linkedList.addAtFirst(40);

		linkedList.addAtFirst(50);
		linkedList.addAtFirst(60);
		linkedList.addAtFirst(70);
		linkedList.addAtFirst(80);
		//linkedList.addAtFirst(90);
		linkedList.print();

		//System.out.println("\n......................");
		//linkedList.deleteFirst();
		//linkedList.print();
		//linkedList.deleteAtPos(3);
		//linkedList.print();

		//linkedList.findLength();
		//linkedList.findMiddle();
		
		linkedList.reverseNode();
		linkedList.print();

	}
	
	public void reverseNode(){
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public void swapNode(int x, int y){

		if( x == y) return;

		//Search for x and keep track of currX and prevX
		Node currX = head, prevX = null;
		while(currX != null && currX.data != x){
			prevX = currX;
			currX = currX.next;
		}

		//Search for y and keep track of currY and prevY
		Node currY = head, prevY = null;
		while(currY != null && currY.data != y){
			prevY = currY;
			currY = currY.next;
		}

		//If either of data is not present
		if(currX == null || currY == null) return;


		// If x is not head of linked list 
		if(prevX != null){
			prevX.next = currY;
		}else
			head = currY;


		if(prevY != null){
			prevY.next = currX;
		}else
			head = currX;

		Node temp;
		temp = currX;
		currX = currY;
		currY = temp;
	}


	public void findMiddle(){
		Node fast = head;;
		Node slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;

			slow = slow.next;
		}

		System.out.println("Middle Element is : "+slow.data);



	}

	public void findLength(){
		Node temp = head;
		int count = 0;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		System.out.println("Length is : "+count);
	}

	public void deleteAtPos(int pos){
		if (pos == 0) {
			deleteFirst();
			return;
		}
		Node temp = head;
		Node prev = null;
		for(int i = 1; i < pos ; i++){
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}

	public  void deleteFirst(){
		if(head != null){
			System.out.println("\nDeleted item : "+head.data);
			head = head.next;
		}
	}

	public  void addAfterNode(Node prev, int val){

		if (prev == null) {
			System.out.println("Given node is invalid");
		}

		Node temp = new Node(val);
		temp.next = prev.next;
		prev.next = temp;
	}

//Focus on below
	public  void addAtLast(int val){
		Node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = new Node(val);
	}

	public  void addAtFirst(int val){
		Node node = new Node(val);
		node.next = head;
		head = node;
	}

	public  void print(){
		Node temp = head;
		while(temp != null){
			System.err.println("The Data is : "+temp.data);
			temp = temp.next;
		}
	}


}
