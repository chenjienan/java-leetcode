package psr;

import java.util.*;


public class PerfectShuffle {
  public void shuffle(int[] array) {
    
    if (array == null || array.length <= 1) {
      return;
    }

    int n = array.length;
    Random r = new Random();

    for (int i = 0; i < n; i++) {
      int temp = array[i];
      int randIdx = r.nextInt(n - i) + i;
      array[i] = array[randIdx];
      array[randIdx] = temp;
    }
  }
  public static void main(String[] args) {
    int[] A = {1,2,3,4,5};
    PerfectShuffle sol = new PerfectShuffle();
    sol.shuffle(A);
    // for (int i = 0; i < A.length; i++) {
    //   System.out.println(A[i]);
    // }
    System.out.print(Arrays.toString(A));
  }
}

// range[1, 30] => range[0, 49] offset: 1
// range[a, b] => r.nextInt(b - a + 1) + a