package dp;


public class LargestXOfOnes {
  public int largest(int[][] matrix) {
    
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] goBottomRight = new int[rows][cols];
    int[][] goBottomLeft = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          goBottomRight[i][j] = getNumber(goBottomRight, i - 1, j - 1, rows, cols) + 1;
          goBottomLeft[i][j] = getNumber(goBottomLeft, i - 1, j + 1, rows, cols) + 1;
        }
      }
    }

    int[][] goTopRight = new int[rows][cols];
    int[][] goTopLeft = new int[rows][cols];
    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          goTopRight[i][j] = getNumber(goTopRight, i + 1, j - 1, rows, cols) + 1;
          goTopLeft[i][j] = getNumber(goTopLeft, i + 1, j + 1, rows, cols) + 1;
        }
      }
    }
    int globalMax = 0;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (matrix[r][c] == 1) {
          int localMax = Math.min(goBottomLeft[r][c], 
            Math.min(goBottomRight[r][c],
            Math.min(goTopLeft[r][c], 
            goTopRight[r][c])));

          globalMax = Math.max(globalMax, localMax);
        }
      }
    }
    return globalMax;
  }

  private int getNumber(int[][] pad, int r, int c, int rows, int cols) {
    if (r < 0 || r >= rows 
      || c < 0 || c >= cols) {
        return 0;
      }
    return pad[r][c];
  }


  public static void main(String[] args) {
    int[][] m = { 
      {0, 0, 0, 0},
      {1, 1, 1, 1}, 
      {0, 1, 1, 1},
      {1, 0, 1, 1} 
    };

    LargestXOfOnes sol = new LargestXOfOnes();
    System.out.println(sol.largest(m));
  }
}
