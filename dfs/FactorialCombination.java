package dfs;
import java.util.*;


public class FactorialCombination {
  public List<List<Integer>> combinations(int target) {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();
    
    if (target <= 0) {
      res.add(sol);
      return res;
    }
    if (target == 1) {
      return res;
    }
    
    HashSet<Integer> factorialsSet = new HashSet<>();

    for (int i = 2; i < target / 2; i++) {
      if (target % i == 0 && !factorialsSet.contains(i)) {
        factorialsSet.add(i);
        factorialsSet.add(target / i);
      }
    }
    if (factorialsSet.isEmpty()) {
      return res;
    }
    
    int[] factorialsArr = new int[factorialsSet.size()];
    int i = 0;
    for (Integer j : factorialsSet) {
      factorialsArr[i++] = j;
    }
    dfs(target, factorialsArr, 0, sol, res);
    return res;
  }

  private void dfs(int target, int[] factArr, int level, List<Integer> sol, List<List<Integer>> res) {

    if (target == 1) {
      res.add(new ArrayList<Integer>(sol));
      return;
    }

    for (int i = level; i < factArr.length; i++) {
      if (target % factArr[i] == 0) {
        sol.add(factArr[i]);
        dfs(target / factArr[i], factArr, i, sol, res);
        sol.remove(sol.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    FactorialCombination sol = new FactorialCombination();
    System.out.println(sol.combinations(24));
  }
}
