package stackqueue;

import java.util.*;

public class SortWithTwoStacks {
	
    public void sort(LinkedList<Integer> s1) {

        if (s1 == null || s1.size() <= 1) {
            return ;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        
        // ensure all items are checked in the buffer part
        int preMin = Integer.MIN_VALUE;
        while (s1.peek() > preMin) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            // put items to s2 for checking
            while (!s1.isEmpty() && s1.peek() > preMin) {
                int curVal = s1.pop();
                if (curVal < curMin) {
                    curMin = curVal;
                    count = 1;
                // count how many curMin value in the buffer part
                }else if (curVal == curMin) {
                    count++;
                }
                s2.push(curVal);
            }
            while (count > 0) {
                s1.push(curMin);
                count--;
            }
            // put back items from s2 to s1
            while (!s2.isEmpty()) {
                int bufferVal = s2.pop();
                if (bufferVal != curMin) {
                    s1.push(bufferVal);
                }
            }
            // renew preMax for preventing sorted items being push back to s2
            preMin = curMin;
        }
    }

    public void sort1(LinkedList<Integer> s1) {

        if (s1 == null || s1.size() <= 1) {
            return ;
        }

        Deque<Integer> s2 = new ArrayDeque<>();
        
        // ensure all items are checked in the buffer part
        int lastMax = Integer.MAX_VALUE;
        while (s1.peekFirst() < lastMax) {
            int curMax = Integer.MIN_VALUE;
            // int count = 0;  
            // put items to s2 for checking
            while (!s1.isEmpty() && s1.peekFirst() < lastMax) {
                int curVal = s1.pollFirst();
                if (curVal > curMax) {
                    curMax = curVal;
                    // count = 1;
                // count how many curMin value in the buffer part
                }
                // else if (curVal == curMax) {
                //     count++;
                // }
                s2.offerFirst(curVal);
            }
            // // add duplicates back
            // while (count > 0) {
            //     s1.offerFirst(curMax);
            //     count--;
            // }
            // put back items from s2 to s1
            while (!s2.isEmpty()) {
                int bufferVal = s2.pollFirst();
                if (bufferVal != curMax) {      // curMax has already added back
                    s1.offerFirst(bufferVal);
                }
            }
            // renew preMax for preventing sorted items being push back to s2
            lastMax = curMax;
        }
    }

    public static void main(String[] args)
	{
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.push(1);
        s1.push(4);
        s1.push(2);
        s1.push(3);

        SortWithTwoStacks s = new SortWithTwoStacks();
        s.sort1(s1);
        while (!s1.isEmpty()) {
            System.out.print(s1.pollFirst() + " ");
        }
	}
}



