package binarysearch;
import java.util.*;

public class SearchInUnknownSizedSortedArray {
	public int search(Map<Integer, Integer> dict, int target) {
    
		int left = 0;
		int right = 1; // look-ahead
		// jump out
		while (dict.get(right) != null && dict.get(right) < target) {
		  left = right;
		  right *= 10;
		}
	
		while (left <= right) {
		  int mid = left + (right - left) / 2;
		  if (dict.get(mid) == null || dict.get(mid) > target) {
			right = mid - 1;
		  } else if (dict.get(mid) == target) {
			return mid;
		  } else if (dict.get(mid) < target) {
			left = mid + 1;
		  } 
		}
		return -1;
	  }
	public static void main(String[] args)
	{
		
	}
}
