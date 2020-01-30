package bit;

import java.util.Arrays;

public class CountingBits {
  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    res[0] = 0;

    int i = 1;
    int j = 0;
    while (i < res.length) {
      if ((i & i - 1) == 0) {
        j = 0;    // reset to 0 if cur value is power of 2
      }
      res[i] = res[j] + 1;    // cur value is based on the previous one

      i++;
      j++;
    }

    return res;

    // Time: O(n) one pass from i = 0 to i = n
    // Space: O(1) auxiliary space 
  }

  public static void main(String[] args) {
    CountingBits sol = new CountingBits();
    System.out.println(Arrays.toString(sol.countBits(9)));
  }
}
