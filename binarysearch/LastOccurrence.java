package binarysearch;
// import java.util.*;

public class LastOccurrence {

	public int searchLast(int[] arr, int target) {
		// check null and empty
		//...

		int left = 0;
		int right = arr.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] <= target) {
				left = mid;
			} else {
				// in this case -1 may not needed. 
				//because array[mid] != target, 
				//mid - 1 will not exclude the answer
				right = mid - 1;	
			}
		}

		// two possible pairs
		// 1. [t, t]  or [t] left == right
		// 2. [t, x]  or [x] left == right
		// therefore, check right first
		if (arr[right] == target) {
			return right;
		} else if (arr[left] == target) {
			return left;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		int[] t1 = new int[]{1,2,3};
		// int[] t2 = new int[]{1,2,3};
		// int[] t3 = new int[]{2,2,2};
		LastOccurrence sol = new LastOccurrence();
		System.out.println(sol.searchLast(t1, 1));
	}
}
