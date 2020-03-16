package array;


public class MaxWaterTrapped {
  public int maxTrapped(int[] array) {
    
    if (array.length == 0) {
      return 0;
    }
    int[] maxLeft = new int[array.length];
    int[] maxRight = new int[array.length];    
    
    maxLeft[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      maxLeft[i] = maxLeft[i - 1] < array[i] ? array[i] : maxLeft[i - 1];
    }

    maxRight[array.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0; i--) {
      maxRight[i] = maxRight[i + 1] < array[i] ? array[i] : maxRight[i + 1];
    } 

    int res = 0;
    for (int i = 0; i < array.length; i++) {
      res += Math.min(maxLeft[i], maxRight[i]) - array[i];
    }

    return res;
  }
}
