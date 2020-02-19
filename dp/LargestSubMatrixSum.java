package dp;
import tools.*;

public class LargestSubMatrixSum {
  public int largest(int[][] matrix) {
    
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    int globalMax = Integer.MIN_VALUE;
    for (int topRow = 0; topRow < rows; topRow++) {
      
      int[] curRow = new int[cols];
      for (int botRow = topRow; botRow < rows; botRow++) {
        addRow(curRow, matrix[botRow]);
        globalMax = Math.max(globalMax, getSubarraySum(curRow));
      }

    }
    return globalMax;
  }

  private void addRow(int[] curRow, int[] row) {
    for (int i = 0; i < curRow.length; i++) {
      curRow[i] += row[i];
    }
  }

  private int getSubarraySum(int[] row) {
    int rowMax = row[0];
    int curMax = row[0];
    for (int i = 1; i < row.length; i++) {
      curMax = Math.max(row[i], curMax + row[i]);
      rowMax = Math.max(rowMax, curMax);
    }
    return rowMax;
  }

  public static void main(String[] args) {
    int[][] m = { {1, -2, -1, 4},

    {1, -1,  1, 1},
  
    {0, -1, -1, 1},
  
    {0,  0,  1, 1} };

    LargestSubMatrixSum sol = new LargestSubMatrixSum();
    System.out.println(sol.largest(m));
  }
}
