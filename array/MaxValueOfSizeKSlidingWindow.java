package array;
import java.util.*;


public class MaxValueOfSizeKSlidingWindow {
  public List<Integer> maxWindows(int[] array, int k) {
        
    List<Integer> res = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>(); // store the idx

    for (int i = 0; i < array.length; i++) {
      // maintain a decreasing deque
      while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
        deque.pollLast();
      }

      // die natrually
      if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      deque.offerLast(i);
      if (i >= k - 1) {
        res.add(array[deque.peekFirst()]);
      }            
    }
    return res;
  }

  public static void main(String[] args) {
    int[] A = {1, 3, 2, 5, 8, 9, 4, 7, 3};
    MaxValueOfSizeKSlidingWindow sol = new MaxValueOfSizeKSlidingWindow();
    System.out.println(sol.maxWindows(A, 3));
  }
}