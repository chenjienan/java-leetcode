package heap;

import java.util.*;

public class KSmallestInUnsortedArray {
    
    // Find the K smallest numbers in an unsorted integer array A. 
    // The returned numbers should be in ascending order.
    public static int[] kSmallest(int[] array, int k) {
        
        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        // create a size-k max heap
        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {    // has same priority
                    return 0;
                }
                // if (o1 > o2) {          // o1 has higher priority than o2
                //     return -1;
                // } else {                // o1 has less priority than o2
                //     return 1;
                // }
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < k; ++i) {   // O(k)
            pq.offer(array[i]);         // O(log k)
        }

        for (int j = k; j < array.length; ++j) {    // O(n-k)
            if (array[j] < pq.peek()) {
                pq.poll();                          // O(log k)
                pq.offer(array[j]);                 // O(log k)
            }
        }

        int[] res = new int[k];

        for (int i = k - 1; i >= 0; --i) {          // O(k)
            res[i] = pq.poll();                     // O(log k)
        }

        return res;
    } 

    public static void main(String[] args)
	{
        int[] arr = new int[]{1,4, 3, 6, 8, 9, 10};
        int[] newArr = kSmallest(arr, 2);
        System.out.println(Arrays.toString(newArr));
    }

}