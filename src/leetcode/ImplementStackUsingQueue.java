package leetcode;

import java.util.*;

/**
* Java queue interface: http://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
* https://leetcode.com/problems/implement-stack-using-queues/
**/

public class ImplementStackUsingQueue {
    
    private Queue<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for(int i=0; i<size; i++){
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        this.queue.poll();
    }

    // Get the top element.
    public int top() {
        return this.queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return this.queue.isEmpty();
    }
}
