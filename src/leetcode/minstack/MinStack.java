package leetcode.minstack;

import java.util.Stack;

class MinStack {

	private Stack<Integer> stack;
	
	private Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<Integer>();
		this.minStack=new Stack<Integer>();
	}

	public void push(int x) {
		
		stack.add(x);

		if(minStack.isEmpty() || minStack.peek()>=x){
			minStack.push(x);
		}
		
	}

	public void pop() {
		
		Integer p = stack.pop();

		if (p.equals(minStack.peek())) {
			minStack.pop();
		}

	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
