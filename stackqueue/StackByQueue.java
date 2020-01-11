package stackqueue;

// LaiCode 634
import java.util.Deque;
import java.util.ArrayDeque;

public class StackByQueue {
    
    private Deque<Integer> queue1;
    private Deque<Integer> queue2;
    /** Initialize your data structure here. */
    public StackByQueue() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer pre = queue1.pollFirst();
        Integer cur = queue1.pollFirst();

        while (cur != null) {
            queue2.offerLast(pre);
            pre = cur;
            cur = queue1.pollFirst();
        }

        // swap queues O(1)
        Deque<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
        
        return pre;
    }

    /** Get the top element. */
    public Integer top() {
        // call internal method
        Integer res = pop();
        if (res != null) {
            return res;
        }
        return null;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args)
	{
		
    }
}


