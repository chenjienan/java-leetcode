package dp;

public class CuttingRope {
  public int maxProduct(int length) {
    int[] memo = new int[length + 1];
    memo[1] = 0;

    for (int i = 2; i <= length; i++) {
      for (int j = 1; j < i; j++) {
        int a = memo[i];
        int b = memo[j];
        int c = i - j;
        memo[i] = Math.max(memo[i], Math.max(j, memo[j]) * (i - j));
      }
    }
    return memo[length];
  }

  public static void main(String[] sss) {
    CuttingRope sol = new CuttingRope();
    System.out.println(sol.maxProduct(5));
  }
}
