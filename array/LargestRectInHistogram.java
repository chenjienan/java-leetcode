package array;
import java.util.*;


public class LargestRectInHistogram {
  public int largest(int[] array) {
    Deque<Integer> monoStack = new ArrayDeque<>();

    int maxRect = 0;
    for (int i = 0; i <= array.length; i++) {      
      int val = i == array.length ?  0 : array[i];
      while (!monoStack.isEmpty() && val <= array[monoStack.peekFirst()]) {   
        int height = array[monoStack.pollFirst()];
        int left = monoStack.isEmpty() ? 0 : monoStack.peekFirst() + 1;
        int localMax = height * (i - left);
        maxRect = Math.max(maxRect, localMax);
      }      
      monoStack.offerFirst(i);
    }
    return maxRect;
  }

  public static void main(String[] args) {
    int[] A = {2, 1, 1};
    LargestRectInHistogram sol = new LargestRectInHistogram();
    System.out.print(sol.largest(A));
  }
}
