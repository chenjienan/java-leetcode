package dp;
import tools.*;

public class LargestSquareOfMatches {
  public int largestSquareOfMatches(int[][] matrix) {
    
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] goUp = new int[rows][cols];
    for (int i = rows - 2; i >= 0; i--) {
      for (int j = 0; j < cols; j++) {        
        if (matrix[i][j] == 2 || matrix[i][j] == 3) {
          goUp[i][j] = goUp[i+1][j] + 1;
        }
      }
    }
    ArrayPrinter.printMatrix(goUp);

    int[][] goLeft = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = cols - 2; j >= 0; j--) {
        if (matrix[i][j] == 1 || matrix[i][j] == 3) {
          goLeft[i][j] = goLeft[i][j+1] + 1;
        }
      }
    }
    ArrayPrinter.printMatrix(goLeft);

    int globalMaxLen = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (matrix[r][c] == 3){
          int maxLen = Math.min(goLeft[r][c], goUp[r][c]);
          for (int len = maxLen; len >= 1; len--) {
            int bottom = goLeft[r + len][c];
            int right = goUp[r][c + len];
            
            if (bottom >= len && right >= len) {
              globalMaxLen = Math.max(globalMaxLen, len);
            }
          }
        }        
      }
    }

    return globalMaxLen;
  }
  
  public static void main(String[] args) {
    int[][] m = {
      {3,1,1,1,1,1,2,0,0},
      {2,1,3,1,0,3,2,0,3},
      {2,0,0,2,3,3,2,1,2},
      {2,1,1,1,0,1,2,0,2},
      {2,2,2,3,0,1,2,0,0},
      {2,1,1,2,3,2,2,0,3},
      {1,1,1,1,1,1,0,1,1},
      {0,3,1,3,1,3,3,3,3},
      {0,3,1,1,2,0,1,3,3}};

    LargestSquareOfMatches sol = new LargestSquareOfMatches();
    System.out.println(sol.largestSquareOfMatches(m));
  }
}
