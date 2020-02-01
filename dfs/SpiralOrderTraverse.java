package dfs;
import java.util.*;

public class SpiralOrderTraverse {
    public List<Integer> spiral(int[][] matrix) {

      List<Integer> res = new ArrayList<>();
      
      dfs(matrix, 0, matrix.length, res);
      return res;
    }

    private void dfs(int[][] matrix, int offset, int size, List<Integer> res) {
      // matrix is not changing
      if (size <= 0) {
        return;
      }
      if (size == 1) {
        res.add(matrix[offset][offset]);
        return;
      }

      // take top
      for (int i = 0; i < size - 1; ++i) {
        res.add(matrix[offset][offset + i]);
      }

      // right
      for (int i = 0; i < size - 1; ++i) {
        res.add(matrix[offset + i][size - 1 + offset]);
      }

      // bottom
      for (int i = 0; i < size - 1; ++i) {
        res.add(matrix[size - 1 + offset][size - 1 + offset - i]);
      }

      // left
      for (int i = 0; i < size - 1; ++i) {
        res.add(matrix[size - 1 + offset - i][offset]);
      }

      dfs(matrix, offset + 1, size - 2, res);
  }

  public List<Integer> spiral2(int[][] matrix) {
    
    List<Integer> res = new ArrayList<>();
    if (matrix.length == 0) {
      return res;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;  
    dfs2(matrix, 0, rows, cols, res);
    return res;
  }

  private void dfs2(int[][] m, int offset, int totalRows, int totalCols, List<Integer> res) {
    // base case
    if (totalRows == 0 || totalCols == 0) {
      return;
    }
    if (totalRows == 1) {
      for (int i = 0; i < totalCols; ++i) {
        res.add(m[offset][offset+i]);
      }
      return;
    }
    if (totalCols == 1) {
      for (int i = 0; i < totalRows; ++i) {
        res.add(m[offset+i][offset]);
      }
      return;
    }
    // top
    for (int i = 0; i < totalCols - 1; ++i) {
      res.add(m[offset][offset+i]);
    }
    // right
    for (int i = 0; i < totalRows - 1; ++i) {
      res.add(m[offset+i][offset+totalCols-1]);
    }
    // bottom
    for (int i = 0; i < totalCols - 1; ++i) {
      res.add(m[offset+totalRows-1][offset+totalCols-1-i]);
    }
    // left
    for (int i = 0; i < totalRows - 1; ++i) {
      res.add(m[offset+totalRows-1-i][offset]);
    }

    dfs2(m, offset+1, totalRows-2, totalCols-2, res);
  }

  public static void main(String[] args) {
    int[][] m = new int[][] {
      {1, 2, 3, 4}, 
      {12, 13, 14, 5},
      {11, 16, 15, 6},
      {10, 9, 8, 7}
    };

    SpiralOrderTraverse sol = new SpiralOrderTraverse();
    System.out.println(sol.spiral(m));

    m = new int[][]{
      {1},
      {2},
      {3}
    };

    System.out.println(sol.spiral2(m));
  }
}
  