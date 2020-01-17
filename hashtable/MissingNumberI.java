package hashtable;


public class MissingNumberI {
  public int missing(int[] array) {
    
    if (array.length == 0) {
      return 1;
    }
    boolean[] map = new boolean[array.length + 2];

    for(int i = 0; i < array.length; ++i) {
      map[array[i]] = true;
    }

    for(int j = 1; j < map.length; ++j) {
      if (!map[j]) {
        return j;
      }
    }
    return array.length;
  }

  public static void main(String[] args) {
      int[] arr = new int[] {12,11,10,9,4,5,6,7,2,3,8};
      MissingNumberI solution = new MissingNumberI();
      System.out.print(solution.missing(arr));
  }
}