package dfs;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class SubsetsWithMinDiff {
  public int minDifference(int[] array) {
    
    int total = 0;
    for (int num : array) {
      total += num;
    }
    
    int[] minDiff = {Integer.MAX_VALUE};
    dfs(array, 0, 0, 0, total, minDiff);

    return minDiff[0];
  }

  private void dfs(int[] array, int level, int subsetSum, int count, int total, int[] minDiff) {
    if (level == array.length) {   
      return;
    }

    if (count == array.length / 2) {
      int curMinDiff = Math.abs((total - subsetSum) - subsetSum);
      minDiff[0] = Math.min(minDiff[0], curMinDiff);   
      return;
    }

    subsetSum += array[level];
    dfs(array, level + 1, subsetSum, count + 1, total, minDiff);
    subsetSum -= array[level];
    dfs(array, level + 1, subsetSum, count, total, minDiff);
  }

  public static void main(String[] args) {
    int[] A = {2,9,3,1,1};
    SubsetsWithMinDiff sol = new SubsetsWithMinDiff();
    System.out.print(sol.minDifference(A));
  }
}


class Test1 {

  @Test
  public void testcase1() {
    assertEquals(1, 1);
  }
}
