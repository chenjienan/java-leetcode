package binarysearch;
// import java.util.*;

import java.util.Arrays;

public class KClosestInSortedArray {

	public int[] kClosest(int[] arr, int target, int k) {
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
		
		int[] res = new int[k];
		for (int i = 0; i < k; ++i) {
			if (left < 0) {
				res[i] = arr[right];
				right++;
			} else if (right >= arr.length) {
				res[i] = arr[left];
				left--;
			} else if (Math.abs(target - arr[left]) < Math.abs(target - arr[right])) {
				res[i] = arr[left];
				left--;
			} else {
				res[i] = arr[right];
				right++;
			}
		}
		return res;
	}
	public static void main(String[] args)
	{
		int[] arr = new int[]{1, 4, 6, 8};
		KClosestInSortedArray sol = new KClosestInSortedArray();
		System.out.println(Arrays.toString(sol.kClosest(arr, 3, 3)));
	}
}
