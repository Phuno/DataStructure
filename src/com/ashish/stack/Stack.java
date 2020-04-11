package com.ashish.stack;

public class Stack {
	
	public static int SIZE = 10;
	
	public int top;
	
	public int[] list;
	
	public Stack(){
		top = -1;
		list = new int[SIZE];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		stack.pop();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.pop();
		stack.pop();

	}
	
	
	public boolean push(int value){
		if(list.length <= SIZE){
			list[++top] = value;
			System.out.println("Push : "+value);
			return true;
		}else{
			System.out.println("Stack is Full");
			return false;
		}
	}
	
	public int pop(){
		if (top > -1) {
			System.out.println("Pop : "+list[top]);
			return list[top--];
		}else{
			System.out.println("Stack is empty");
			return -1;
		}
	}

}
