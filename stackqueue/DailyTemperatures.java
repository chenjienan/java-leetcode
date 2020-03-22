package stackqueue;
import java.util.*;


class DailyTemperatures {
  public int[] dailyTemperatures(int[] T) {
      
    int[] res = new int[T.length];
    if (T == null || T.length == 0) {
      return res;
    }
    
    // store the idx of days that cannot find a warmer temperature in the future
    // 单调栈思路，记录单调递减的元素
    // 遇到比栈顶元素大的数，批量处理栈中元素
    Deque<Integer> stack = new ArrayDeque<>(); 
    
    for (int i = 0; i < T.length; i++) {      
      while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]) {
        int idx = stack.pollFirst();
        res[idx] = i - idx;
      }  
      
      stack.offerFirst(i);
    }

    // post processing
    while(!stack.isEmpty()) {
      res[stack.pollFirst()] = 0;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] a = {73, 74, 75, 71, 69, 72, 76, 73};

    DailyTemperatures sol = new DailyTemperatures();
    System.out.println(Arrays.toString(sol.dailyTemperatures(a)));
  }
}