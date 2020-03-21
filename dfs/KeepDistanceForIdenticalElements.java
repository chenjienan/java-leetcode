package dfs;


public class KeepDistanceForIdenticalElements {

  public int[] keepDistance(int k) {
    
    int[] res = new int[2 * k];        
    return dfs(k, res) ? res : null;
  }

  private boolean dfs(int curNum, int[] res) {

    if (curNum == 0) {
      return true;
    }
    for (int i = 0; i < res.length - curNum - 1; i++) {
      // check if we can put number i in current index
      if (res[i] == 0 && res[i + curNum + 1] == 0){
        res[i] = curNum;
        res[i + curNum + 1] = curNum;
        if (dfs(curNum - 1, res)) {
          return true;
        }
        
        res[i] = 0;
        res[i + curNum + 1] = 0;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    KeepDistanceForIdenticalElements sol = new KeepDistanceForIdenticalElements();

    int[] A = sol.keepDistance(4);

    for (int num : A){
      System.out.println(num);
    }
  }
}