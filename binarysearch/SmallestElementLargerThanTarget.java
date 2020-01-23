package binarysearch;
// import java.util.*;

public class SmallestElementLargerThanTarget {
	
	public int smallestElementLargerThanTarget(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] <= target) {
				left = mid + 1;  // needs the element larger than T
			} else {
				right = mid;
			}			
		}
		// check left first, because mid + 1
		// left, right may not come from while loop
		// need to compare with target
		if (arr[left] > target) { 
			return left;
		}
		if (arr[right] > target) {
			return right;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		
	}
}
