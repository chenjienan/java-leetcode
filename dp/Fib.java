package dp;

public class Fib {
  public long fibonacci(int K) {
    
    if (K <= 0) {
      return 0;
    }

    long[] memo = new long[K+1];
    memo[0] = 0;
    memo[1] = 1;

    if (K >= 2) {
      for (int i = 2; i <= K; i++) {
        memo[i] = memo[i-1] + memo[i-2];
      }
    }
    return memo[K];
  }

  public static void main(String[] sss) {
    Fib sol = new Fib();
    System.out.println(sol.fibonacci(0));
  }
}
