package dfs;

import java.util.*;


public class AllValidPermutationsOfParenthesesIII {

  private static final char[] leftMap = {'(', '<', '{'};
  private static final char[] rightMap = {')', '>', '}'};

  public List<String> validParentheses(int l, int m, int n) {
    
    int[] totalLeft = {l, m, n};
    int[] totalRight = {l, m, n};
    int[] addedLeft = new int[3];
    int[] addedRight = new int[3];

    Deque<Integer> stack = new ArrayDeque<>();
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(totalLeft, totalRight, addedLeft, addedRight, sb, stack, res);
    return res;
  }

  private void dfs(int[] totalLeft, int[] totalRight, int[] addedLeft, int[] addedRight, 
                  StringBuilder prefix, Deque<Integer> stack, List<String> res) {

    if (addedLeft[0] + addedRight[0] == totalLeft[0] + totalRight[0] &&
        addedLeft[1] + addedRight[1] == totalLeft[1] + totalRight[1] &&
        addedLeft[2] + addedRight[2] == totalLeft[2] + totalRight[2]) {
      res.add(prefix.toString());
      return;
    }

    for (int i = 0; i < addedLeft.length; i++) {
      if (addedLeft[i] < totalLeft[i] && (stack.isEmpty() || stack.peekFirst() > i)) {
        prefix.append(leftMap[i]);
        addedLeft[i]++;
        stack.offerFirst(i);
        dfs(totalLeft, totalRight, addedLeft, addedRight, prefix, stack, res);
                
        prefix.deleteCharAt(prefix.length() - 1);
        addedLeft[i]--;
        stack.pollFirst();
      }
    }

    for (int j = 0; j < addedRight.length; j++) {
      if (!stack.isEmpty() && stack.peekFirst() == j) {
        prefix.append(rightMap[j]);
        addedRight[j]++;
        stack.pollFirst();
        dfs(totalLeft, totalRight, addedLeft, addedRight, prefix, stack, res);

        prefix.deleteCharAt(prefix.length() - 1);
        addedRight[j]--;
        stack.offerFirst(j);
      }
    }
  }

  public static void main(String[] args) {
    AllValidPermutationsOfParenthesesIII sol = new AllValidPermutationsOfParenthesesIII();
    System.out.print(sol.validParentheses(1, 1, 1));
  }
}
