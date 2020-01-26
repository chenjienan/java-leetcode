package heap;

import java.util.*;

public class KSortedArray {
    public int[] ksort(int[] array, int k) {
      // heapify?

      // size-k+1 min heap
      Queue<Integer> pq = new PriorityQueue<>(k+1);
      
      // just in case k == 1, we need to get the second element involved
      for (int i = 0; i <= k; ++i) { // k
        pq.offer(array[i]);         // log k
      }

      // we are sure that each number in heap can reach its position
      for (int j = 0; j < array.length; ++j) { // n        
        array[j] = pq.poll();                // log k
        if (j + k + 1 < array.length) {
            pq.offer(array[j + k + 1]);          // log k
        }          
      }
      return array;      
    }

    public static void main (String[] args) {
        
        int[] arr = new int[] {2,1,4,3,5};

        KSortedArray sol = new KSortedArray();
        System.out.println(Arrays.toString(sol.ksort(arr, 1)));
    }
  }