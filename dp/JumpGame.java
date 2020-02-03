package dp;

public class JumpGame {
  public boolean canJump(int[] array) {
    
    boolean[] memo = new boolean[array.length];
    memo[0] = true;

    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        if (memo[j] && array[j] + j >= i) {
          memo[i] = true;
        }
      }
    }
    return memo[array.length - 1];
  }
}
