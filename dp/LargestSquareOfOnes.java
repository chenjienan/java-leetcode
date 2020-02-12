package dp;



public class LargestSquareOfOnes {
  public int largest(int[][] matrix) {
    
    int n = matrix.length;

    if (n <= 0) {
      return 0; 
    }

    int[][] memo = new int[n][n];

    // base case
    int globalMax = 0;
    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 1) {
        memo[i][0] = 1;
        globalMax = 1;
      }        
    }

    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 1) {
        memo[0][j] = 1;
        globalMax = 1;
      }
      
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {                
        if (matrix[i][j] == 1) {
          int top = memo[i-1][j];
          int topLeft = memo[i-1][j-1];
          int left = memo[i][j-1];
          memo[i][j] = Math.min(Math.min(top, topLeft), left) + 1;       
        } 
        // else: we keep memo[i][j] to 0 as default     
        globalMax = Math.max(globalMax, memo[i][j]);
      }
    }
    return globalMax;
  }

  public static void main(String[] args) {
    int[][] m = {
      {1,1,1,1},
      {1,1,1,1},
      {1,1,1,1},
      {1,1,1,1}};

    LargestSquareOfOnes sol = new LargestSquareOfOnes();
    System.out.println(sol.largest(m));
  }
}
