package dfs;
import java.util.*;


public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    dfs(candidates, target, 0, subset, res);
    return res;
  }

  private void dfs(int[] candidates, int remain, int level, List<Integer> subset, List<List<Integer>> res) {
    // base case
    if (remain == 0) { // found the subset
      res.add(new ArrayList<Integer>(subset));
      return;
    }

    if (remain < 0) {
      return;
    }

    for (int i = level; i < candidates.length; i++) {
      subset.add(candidates[i]);
      dfs(candidates, remain - candidates[i], i, subset, res);  // consider cur level
      subset.remove(subset.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    Arrays.sort(num);
    dfs2(num, target, 0, subset, res);
    return res;
  }

  private void dfs2(int[] candidates, int remain, int level, List<Integer> subset, List<List<Integer>> res) {
    // base case
    if (remain == 0) { // found the subset
      res.add(new ArrayList<Integer>(subset));
      return;
    }

    if (remain < 0) {
      return;
    }

    for (int i = level; i < candidates.length; i++) {
      if (i > level && candidates[i] == candidates[i-1]) {
        continue;
      }
      subset.add(candidates[i]);
      dfs2(candidates, remain - candidates[i], i + 1, subset, res); // not to add cur level
      subset.remove(subset.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = {7, 3, 6, 2};
    CombinationSum sol = new CombinationSum();
    // System.out.println(sol.combinationSum(arr, 7));

    int[] arr2 = {10,1,2,7,6,1,5};
    System.out.println(sol.combinationSum2(arr2, 8));
  }
}
