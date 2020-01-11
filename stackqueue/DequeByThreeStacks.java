package stackqueue;

import java.util.*;

public class DequeByThreeStacks {

    private Deque<Integer> leftStack;
    private Deque<Integer> rightStack;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        leftStack = new ArrayDeque<>();
        rightStack = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }
    
    public void offerFirst(int element) {
        leftStack.offerFirst(element);
    }
    
    public void offerLast(int element) {
        rightStack.offerLast(element);
    }
    
    public Integer pollFirst() {
        if (isEmpty()) {
            return null;
        }
        if (leftStack.isEmpty()) {
            // 1. move size/2 elements from rightStack to buffer
            int curSize = rightStack.size();
            for (int i = 0; i < curSize / 2; ++i) {
                buffer.offerFirst(rightStack.pollFirst());
            }
            // 2. move the rest of the elements from rightStack to leftStack
            while (!rightStack.isEmpty()) {
                leftStack.offerFirst(rightStack.pollFirst());    
            }                        
            // 3. move elements from buffer to rightStack
            while (!buffer.isEmpty()) {
                rightStack.offerFirst(buffer.pollFirst());
            }
        }
        return leftStack.pollFirst();
    }
    
    public Integer pollLast() {
        if (isEmpty()) {
            return null;
        }
        if (rightStack.isEmpty()) {
            // 1. move size/2 elements from leftStack to buffer
            int curSize = leftStack.size();
            for (int i = 0; i < curSize / 2; ++i) {
                buffer.offerFirst(leftStack.pollFirst());
            }
            // 2. move the rest of the elements from leftStack to rightStack
            while (!leftStack.isEmpty()) {
                rightStack.offerFirst(leftStack.pollFirst());    
            }                        
            // 3. move elements from buffer to leftStack
            while (!buffer.isEmpty()) {
                leftStack.offerFirst(buffer.pollFirst());
            }
        }
        return rightStack.pollFirst();
    }
    
    public Integer peekFirst() {
        if (isEmpty()) {
            return null;
        }

        Integer val = pollFirst();
        offerFirst(val);
        return val;
    }
    
    public Integer peekLast() {
        if (isEmpty()) {
            return null;
        }

        Integer val = pollLast();
        offerLast(val);
        return val;
    }
    
    public int size() {
        return leftStack.size() + rightStack.size();
    }
    
    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

	public static void main(String[] args)
	{
        DequeByThreeStacks myStack = new DequeByThreeStacks();
        
        myStack.offerFirst(1);
        myStack.offerFirst(2);
        myStack.offerFirst(3);

        System.out.println(myStack.pollLast());
        System.out.println(myStack.pollLast());
        System.out.println(myStack.pollLast());
        System.out.println(myStack.pollLast());
	}
}



