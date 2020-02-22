package array;
import java.util.*;

public class Deduplication {
  public int[] dedup(int[] array) {
    if (array.length < 2) {
      return array;
    }

    int slow = 1;    
    for (int fast = 2; fast < array.length; fast++) {
      if (array[slow - 1] != array[fast]) {
        slow++;
        array[slow] = array[fast];
      } 
    }

    int[] res = new int[slow + 1];
    for (int i = 0; i <= slow; i++) { // including slow
      res[i] = array[i];
    }
    return res;
  }  

  public static void main(String[] args) {
    int[] a = {1,1, 2, 3, 3, 3};
    Deduplication sol = new Deduplication();
    System.out.println(Arrays.toString(sol.dedup(a)));
  }
}
