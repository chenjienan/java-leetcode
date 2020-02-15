package dp;

public class LongestCrossOfOnes {
  public int largest(int[][] matrix) {
    
    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] goRight = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      goRight[i][0] = matrix[i][0];
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 1) {
          goRight[i][j] = goRight[i][j - 1] + 1;
        } else {
          goRight[i][j] = 0;
        }
      }
    }

    int[][] goLeft = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      goLeft[i][cols - 1] = matrix[i][cols - 1];
    }
    for (int i = 0; i < rows; i++) {
      for (int j = cols - 2; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          goLeft[i][j] = goLeft[i][j + 1] + 1;
        } else {
          goLeft[i][j] = 0;
        }
      }
    }

    int[][] goDown = new int[rows][cols];
    for (int j = 0; j < cols; j++) {
      goDown[0][j] = matrix[0][j];
    }
    for (int j = 0; j < cols; j++) {
      for (int i = 1; i < rows; i++) {
        if (matrix[i][j] == 1) {
          goDown[i][j] = goDown[i - 1][j] + 1;
        } else {
          goDown[i][j] = 0;
        }
      }
    }

    int[][] goUp = new int[rows][cols];
    for (int j = 0; j < cols; j++) {
      goUp[rows - 1][j] = matrix[rows - 1][j];
    }
    for (int j = 0; j < cols; j++) {
      for (int i = rows - 2; i >= 0; i--) {
        if (matrix[i][j] == 1) {
          goUp[i][j] = goUp[i + 1][j] + 1;
        } else {
          goUp[i][j] = 0;
        }
      }
    }

    int globalMax = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int localMax = Math.min(goRight[r][c], Math.min(Math.min(goDown[r][c], goUp[r][c]), goLeft[r][c]));
        globalMax = Math.max(globalMax, localMax);
      }
    }

    return globalMax;
  }
}
