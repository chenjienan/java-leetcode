package binarysearch;
import java.util.*;




public class ClosestInSortedArray {

	public int searchClosest(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}			
		}
		if (Math.abs(target - arr[left]) < Math.abs(target - arr[right])) {
			return left;
		}
		return right;
	}
	public static void main(String[] args)
	{
		// int[] arr = new int[] {1,3,5,8,10};
		int[] arr = new int[] {1, 2, 3};
		ClosestInSortedArray sol = new ClosestInSortedArray();
		System.out.println(sol.searchClosest(arr, 7));
	}
}
