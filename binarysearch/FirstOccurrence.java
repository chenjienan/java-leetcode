package binarysearch;


public class FirstOccurrence {
  public int firstOccur(int[] array, int target) {
        
    if (array == null || array.length == 0) {
      return -1;
    }    

    int left = 0;
    int right = array.length - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) /2;

      if (array[mid] >= target) { // keep searching 
        right = mid;
      } else {
        left = mid;
      }
    }

    if (array[left] == target) {
      return left;
    }
    if (array[right] == target) {
      return right;
    }

    return -1;
  }
}
