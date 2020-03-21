package recursion;


public class Power {
  public long power(int a, int b) {
    if (b == 0){
      return 1;
    }

    long half = power(a, b / 2);
    if (b % 2 == 0) {
      return half * half;
    }else {
      return half * half * a;
    }
  }
}

// Time: O(1 + 2^1 + 2^2 + ... + 2^logb) => 等比数列求和 O(b)
// Space: O(log b) 有log b层
