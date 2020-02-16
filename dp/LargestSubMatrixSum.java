package dp;
import tools.*;

public class LargestSubMatrixSum {
  public int largest(int[][] matrix) {
    
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    int globalMax = Integer.MIN_VALUE;
    int[][] prefixM = new int[rows][cols];

    prefixM[0][0] = matrix[0][0];
    globalMax = matrix[0][0];
    for (int i = 1; i < rows; i++) {
      prefixM[i][0] = prefixM[i-1][0] + matrix[i][0];      
    }
    for (int j = 1; j < cols; j++) {
      prefixM[0][j] = prefixM[0][j-1] + matrix[0][j];      
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        prefixM[i][j] = prefixM[i][j-1] + prefixM[i-1][j] 
                        + matrix[i][j] - prefixM[i-1][j-1];
      }
    }

    ArrayPrinter.printMatrix(prefixM);

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            int localMax = prefixM[i][j] - prefixM[r][j] - prefixM[i][c] + prefixM[r][c];
            globalMax = Math.max(globalMax, localMax);
            
          }
        }
      }
    }
    return globalMax;
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
