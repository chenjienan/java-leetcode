package dp;

public class LargestSquareSurroundedByOne {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] goUp = new int[rows][cols];
    for (int i = rows - 1; i >= 0; i--) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          if (i == rows - 1){
            goUp[i][j] = 1;
          } else {
            goUp[i][j] = goUp[i+1][j] + 1;
          }
        }
      }
    }

    int[][] goLeft = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = cols - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          if (j == cols - 1) {
            goLeft[i][j] = 1;
          } else {
            goLeft[i][j] = goLeft[i][j + 1] + 1;
          }
        }
      }
    }

    int globalMaxLen = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int top = goLeft[r][c];
        int left = goUp[r][c];
        int maxLen = Math.min(top, left); 
        for (int len = maxLen; len >= 1; len--) {          
          int bottom = goLeft[r + len - 1][c];
          int right = goUp[r][c + len - 1];          
          if (bottom >= len && right >= len) {
            globalMaxLen = Math.max(globalMaxLen, len);
          }
        }        
      }
    }
    return globalMaxLen;
  }

  public static void main(String[] args) {
    int[][] m = {
      {1,1,1,1,1,1},
      {1,1,1,0,0,1},
      {1,1,1,1,0,1},
      {1,0,1,0,0,1},
      {1,1,1,1,0,1},
      {0,1,1,1,1,1}};

    LargestSquareSurroundedByOne sol = new LargestSquareSurroundedByOne();
    System.out.println(sol.largestSquareSurroundedByOne(m));
  }
}
