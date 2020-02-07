package dfs;
import java.util.*;


public class FactorialCombination {
  public List<List<Integer>> combinations(int target) {

    // TODO: check target value
    // ...
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();
    HashSet<Integer> factorials = new HashSet<>();

    for (int i = 2; i < target / 2; i++) {
      if (target % i == 0 && !factorials.contains(i)) {
        factorials.add(i);
        factorials.add(target / i);
      }
    }
    if (factorials.isEmpty()) {
      res.add(sol);
      return res;
    }
    dfs(target, sol, res);
    return res;
  }

  private void dfs(int target, List<Integer> sol, List<List<Integer>> res) {

    if (target == 0) {
      res.add(new ArrayList<Integer>(sol));
      return;
    }


  }

  public static void main(String[] args) {
    FactorialCombination sol = new FactorialCombination();
    System.out.println(sol.combinations(23));
  }
}
