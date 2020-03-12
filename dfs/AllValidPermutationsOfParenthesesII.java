package dfs;

import java.util.*;


public class AllValidPermutationsOfParenthesesII {

  private static final char[] leftMap = {'(', '<', '{'};
  private static final char[] rightMap = {')', '>', '}'};
  
  public List<String> validParentheses(int l, int m, int n) {
    
    int[] leftTotal = {l, m, n};
    int[] rightTotal = {l, m, n};
    int[] addedLeft = new int[3];
    int[] addedRight = new int[3];
    
    StringBuilder prefix = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();
    List<String> res = new ArrayList<>();
    dfs(leftTotal, rightTotal, addedLeft, addedRight, prefix, stack, res);
    return res;
  }
  
  private void dfs(int[] leftTotal, int[] rightTotal, int[] addedLeft, int[] addedRight, StringBuilder prefix, Deque<Character> stack, List<String> res) {
  
    if (addedLeft[0] + addedRight[0] == leftTotal[0] + rightTotal[0] &&
        addedLeft[1] + addedRight[1] == leftTotal[1] + rightTotal[1] &&
        addedLeft[2] + addedRight[2] == leftTotal[2] + rightTotal[2] ) {
        
        res.add(prefix.toString());
        return;
    }
    
    for (int i = 0; i < addedLeft.length; i++) {
      if (addedLeft[i] < leftTotal[i]) {
        prefix.append(leftMap[i]);
        addedLeft[i]++;
        stack.offerFirst(leftMap[i]);
        dfs(leftTotal, rightTotal, addedLeft, addedRight, prefix, stack, res);
        
        prefix.deleteCharAt(prefix.length() - 1);
        addedLeft[i]--;
        stack.pollFirst();
      }
    }
    
    for (int j = 0; j < addedRight.length; j++) {
      if (!stack.isEmpty() && stack.peekFirst() == leftMap[j]) {
        prefix.append(rightMap[j]);
        addedRight[j]++;
        stack.pollFirst();
        dfs(leftTotal, rightTotal, addedLeft, addedRight, prefix, stack, res);
        
        prefix.deleteCharAt(prefix.length() - 1);
        addedRight[j]--;
        stack.offerFirst(leftMap[j]);
      }
    }
  }
  public static void main(String[] args) {
    AllValidPermutationsOfParenthesesII sol = new AllValidPermutationsOfParenthesesII();
    System.out.print(sol.validParentheses(1, 1, 2));
  }
}
