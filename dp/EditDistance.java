package dp;

public class EditDistance {
  public int editDistance(String s1, String s2) {

    // DFS apporach
    // base case
    if (s1.isEmpty()) {
      return s2.length();
    }
    if (s2.isEmpty()) {
      return s1.length();
    }

    // recursive step
    // case 1: first char match
    if (s1.charAt(0) == s2.charAt(0)) { 
      return editDistance(s1.substring(1), s2.substring(1));
    }

    // case 2: replace
    int replace = editDistance(s1.substring(1), s2.substring(1)) + 1;
    // case 3: delete
    int delete = editDistance(s1.substring(1), s2) + 1;
    // case 4: insert
    int insert = editDistance(s1, s2.substring(1)) + 1;

    return Math.min(Math.min(replace, delete), insert);
  }

  public int editDistance2(String s1, String s2) {
    // DP approach
    int n = s1.length();
    int m = s2.length();
    int[][] memo = new int[n + 1][m + 1];

    // base case
    for (int i = 0; i <= n; i++) {
      memo[i][0] = i;
    }
    for (int j = 0; j <= m; j++) {
      memo[0][j] = j;
    }

    // inductive rule
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          memo[i][j] = memo[i-1][j-1];
        } else {
          int replace = 1 + memo[i-1][j-1];  // replace
          int delete = 1 + memo[i-1][j];
          int insert = 1 + memo[i][j-1];
          memo[i][j] = Math.min(Math.min(replace, delete), insert);
        }
      }
    }
    return memo[n][m];

  }

  public static void main(String[] args) {
    EditDistance sol = new EditDistance();
    System.out.println(sol.editDistance2("sigh", "asith"));
  }

}
