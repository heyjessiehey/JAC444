package ws1;

public class Stack {
	private char[] string; 
	private int top;
	
	//one argument constructor
	Stack(int size){
		string = new char[size];
		top = -1;
	}
	
	public char pop(){	
		if(isEmpty()){ // if stack is empty, nothing to pop
			System.out.println("Stack is Empty!");
			return  0;
		}else{
			char character = string[top];
			string[top] = 0; //LIFO: delete the last element
			top--;
			return character;
		}
	}
	
	public void push(char character){
		this.string[++top] = character;
	}
	
	public boolean isEmpty(){ 
		return (top == -1);
	}
	
	public char[] getString(){ //accessing private field from main method
		return string;
	}
}
