package dfs;
import java.util.*;

public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    
    if (n == 0 || k == 0 || k > n) {
      res.add(subset);
      return res;
    }

    if (k == n) {
      for (int i = 1; i <= n; i++) {
        subset.add(i);
      }
      res.add(subset);
      return res;
    }
    
    // start from 1
    dfs(n, k, 1, subset, res);
    return res;
  }

  private void dfs(int n, int k, int curInt, List<Integer> subset, List<List<Integer>> res) {
    
    
    // base case
    if (subset.size() == k) {
      res.add(new ArrayList<Integer>(subset));
      return;
    }
    // be careful of the base case when subset doesn't meet the requirement 
    // but curInt will continue adding
    if (curInt == n + 1) {
      return;
    }

    subset.add(curInt);
    dfs(n, k, curInt + 1, subset, res);
    subset.remove(subset.size() - 1);     // remove last
    dfs(n, k, curInt + 1, subset, res);   // add the next value
  }

  public static void main(String[] args) {
    Combinations sol = new Combinations();
    System.out.println(sol.combine(5, 3));
  }
}
