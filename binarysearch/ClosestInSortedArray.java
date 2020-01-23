package binarysearch;
import java.util.*;


/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
The first element of next row is larger than (or equal to) the last element of previous row.
Given a target number, returning the position that the target locates within the matrix. If 
the target number does not exist in the matrix, return {-1, -1}.

Assumptions:
The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
*/

public class ClosestInSortedArray {
	public int[] search(int[][] matrix, int target) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int left = 0;
		int right = rows * cols - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int r = mid / cols;
			int c = mid % cols;

			if (matrix[r][c] == target) {
				return new int[] {r, c};
			} else if (matrix[r][c] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;		// has to +1 and -1, edge case: {{1}} only one element
			}

		}
		return new int[] {-1, -1};
	}
	public static void main(String[] args)
	{
		int[][] m = new int[][] {
			{1}
		};
		ClosestInSortedArray sol = new ClosestInSortedArray();
		System.out.println(Arrays.toString(sol.search(m, 3)));
	}
}
