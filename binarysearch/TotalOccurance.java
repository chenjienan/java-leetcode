package binarysearch;

public class TotalOccurance {
  public int totalOccurrence(int[] array, int target) {

    if (array == null || array.length == 0) {
      return 0;
    }    

    int left = 0;
    int right = array.length - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;

      if (array[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    int idx = -1;
    int count = 0;
    if (array[left] == target) {
      idx = left;
    } else if (array[right] == target) {
      idx = right;
    } else {
      return 0;
    }

    while (idx < array.length && array[idx] == target) {
      count++;
      idx++;
    }

    return count;
  }

  public static void main(String[] args) {
    int[] a = {1,2,2,2,4,5,8,13,13};

    TotalOccurance sol = new TotalOccurance();
    System.out.println(sol.totalOccurrence(a, 13));
  }
}