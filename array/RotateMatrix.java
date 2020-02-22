package array;
import tools.*;

public class RotateMatrix {
  public void rotate(int[][] matrix) {

    int n = matrix.length;
    helper(matrix, 0, n);
  }

  private void helper(int[][] matrix, int offset, int size) {
    // base case
    if (size <= 1) {
      return;
    }

    if (size == 2) {
      int top = matrix[offset][offset];
      int right = matrix[offset][offset + 1];
      int bot = matrix[offset + 1][offset + 1];
      int left = matrix[offset + 1][offset];
      
      matrix[offset][offset + 1] = top;
      matrix[offset + 1][offset + 1] = right;
      matrix[offset + 1][offset] = bot;
      matrix[offset][offset] = left;
      return;
    }
    
    for (int i = offset; i < size - 1; i++) {
      int top = matrix[offset][i];
      int right = matrix[i][size - 1];
      int bot = matrix[size - 1][size - 1 - i];
      int left = matrix[size - 1 - i][offset];
      
      matrix[i][size - 1] = top;
      matrix[size - 1][size - 1 - i] = right;
      matrix[size - 1 - i][offset] = bot;
      matrix[offset][i] = left;
    }    
    helper(matrix, offset + 1, size - 2);
  }

  public static void main(String[] args) {
    // int[][] m = {
    //   {1,2,3,4},
    //   {5,6,7,8},
    //   {9,10,11,12},
    //   {13,14,15,16}
    //   };

    int[][] m = {
      {1,2},
      {3,4}};
    RotateMatrix sol = new RotateMatrix();
    sol.rotate(m);
    ArrayPrinter.printMatrix(m);
  }
}
