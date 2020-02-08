package dp;

import java.util.*;

public class DictionaryWord {
  public boolean canBreak(String input, String[] dict) {
    
    HashSet<String> dictSet = new HashSet<>(Arrays.asList(dict)); 
    int n = input.length();
    // semantics: memo[i] can break substring 0 - i (exclude i) according to dict
    boolean[] memo = new boolean[n + 1];
    
    // base case
    memo[0] = true;
    for (int i = 1; i < n + 1; i++) {
      for (int j = 0; j < i; j++ ) {    // j is the cut
        if (memo[i]) {
          break;
        }
        boolean part1 = memo[j];
        boolean part2 = dictSet.contains(input.substring(j, i));
        memo[i] = part1 && part2;
      }
    }
    return memo[n];
  }

  public static void main(String[] args) {
    String[] strArray = {"bob", "cat", "rob"};
    String str = "robcatbob";

    DictionaryWord sol = new DictionaryWord();
    System.out.println(sol.canBreak(str, strArray));
  }
}
