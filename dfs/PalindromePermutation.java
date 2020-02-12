package dfs;

import java.util.*;

public class PalindromePermutation {
  public boolean canPermutePalindrome(String input) {
    
    HashMap<Character, Integer> counter = new HashMap<>();

    for (int i = 0; i < input.length(); ++i) {
      Character ch = input.charAt(i);
      Integer value = counter.get(ch);
      if (value == null) {
        value = 0;
      } 
      counter.put(ch, ++value);
    }

    boolean foundOdd = false;   // only allow one odd number of char
    for (Map.Entry<Character, Integer> pair : counter.entrySet()) {
      
      if (pair.getValue() % 2 != 0) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  public List<String> generatePalindromes(String input) {
    List<String> res = new ArrayList<>();

    char[] strArr = input.toCharArray();

    dfs(strArr, 0, res);
    return res;
  }

  // swap - swap
  private void dfs(char[] strArr, int idx, List<String> res) {
    // base case
    if (idx == strArr.length - 1) {
      
      // check if it is palindrome
      if (isPalindrome(strArr)) {
        res.add(new String(strArr));
      }
      return;
    }
    HashSet<Character> used = new HashSet<>();
    for (int i = idx; i < strArr.length; i++) {
      if (!used.contains(strArr[i])) {
        used.add(strArr[i]);
        swap(strArr, i, idx);
        dfs(strArr, idx + 1, res);
        swap(strArr, i, idx);
      }
      
    }
  }

  private boolean isPalindrome(char[] strArr) {
    int i = 0;
    int j = strArr.length - 1;
    while (i < j) {
      if (strArr[i] != strArr[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  public static void main(String[] args) {
    PalindromePermutation sol = new PalindromePermutation();
    System.out.println(sol.canPermutePalindrome("abc"));
    System.out.println(sol.generatePalindromes("aabb"));
  }

  
}
