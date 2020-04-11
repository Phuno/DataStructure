package com.ashish.queue;

public class Queue {

	public static int CAPACITY = 10;
	int front = -1;
	int rear = CAPACITY -1, size = 0;
	int[] list = new int[CAPACITY];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		System.out.println(queue.front());
		System.out.println(queue.rear());
		
		
	}
	
	public boolean isFull(){
		return (list.length == CAPACITY);
	}
	
	public boolean isEmpty(){
		return (list.length == 0);
	}
	
	
	public void enqueue(int val){
		if (isFull()) {
			return ;
		}
		
		rear = (rear+1)%CAPACITY;
		list[rear] = val;
		++size;
		System.out.println(val+ " enqueued to queue");
		
	}
	
	public int dequeue(){
		
		if (isEmpty()) {
			return -1;
		}
		int val= list[front];
		front = (front +1)%CAPACITY;
		size--;
		return val;
	}
	
	public int front(){
		return list[front];
	}
	
	public int rear(){
		return list[rear];
	}
	
	
	

}
