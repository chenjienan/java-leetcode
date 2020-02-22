package dp;


public class MinCutForPalindrome {
  public int minCuts(String input) {
    
    int[] minCut = new int[input.length()];

    for (int right = 0; right < input.length(); right++) {
      minCut[right] = right;
      for (int left = 0; left <= right; left++) {
        if (isPalindrome(input, left, right)) {
        
          if (left == 0) {
            minCut[right] = 0;
          } else {
            minCut[right] = Math.min(minCut[right], minCut[left-1] + 1);
          }
        }        
      }
    }
    return minCut[input.length() - 1];
  }

  private boolean isPalindrome(String s, int i, int j) { 
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "abcde";
    MinCutForPalindrome sol = new MinCutForPalindrome();
    System.out.print(sol.minCuts(s));
  }
}
