package dfs;
import java.util.*;

public class NQueens {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();

    dfs(n, sol, res);
    return res;
  }

  private void dfs(int n, List<Integer> sol, List<List<Integer>> res) {
    // base case
    if (sol.size() == n) {
      res.add(new ArrayList<Integer>(sol));
      return;
    }

    // recursive rule
    for (int i = 0; i < n; ++i) {
      sol.add(i);
      if (isValidPos(sol)){
        dfs(n, sol, res);
      }
      sol.remove(sol.size() - 1);
    }
  }

  // check the last row
  private boolean isValidPos(List<Integer> sol) {
    int row = sol.size() - 1;
    int col = sol.get(row);
    
    for (int i = 0; i < row; i++) {
      // we are sure that there will be no conflict in the same row
      // check vertical line, and diagonal line
      if (col == sol.get(i) || Math.abs(col - sol.get(i)) == row - i) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    NQueens sol = new NQueens();
    System.out.println(sol.nqueens(8));
  }
}
