package sorting;
import java.util.*;

class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr == null) {
            return arr;
        }

        int[] helperArr = new int[arr.length];
        mergeSort(arr, helperArr, 0, arr.length - 1);

        return arr;
    }

    private void mergeSort(int[] arr, int[] helperArr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, helperArr, left, mid);
        mergeSort(arr, helperArr, mid + 1, right);
        merge(arr, helperArr, left, mid, right);

    }

    private void merge(int[] arr, int[] helperArr, int left, int mid, int right) {
        for (int i = left; i <= right; ++i) {
            helperArr[i] = arr[i];
        }
        
        int leftIdx = left;     // for helper
        int rightIdx = mid + 1;

        while (leftIdx <= mid && rightIdx <= right) {
            if (helperArr[leftIdx] < helperArr[rightIdx]) {
                arr[left++] = helperArr[leftIdx++];
            } else {
                arr[left++] = helperArr[rightIdx++];
            }
        }

        while (leftIdx <= mid) {
            arr[left++] = helperArr[leftIdx++];
        }
    }
	public static void main(String[] args)
	{
        int[] arr = new int[] {3, 4, 2, 6, 8}; // 2, 4, 6, 8
        MergeSort sol = new MergeSort();

        System.out.println(Arrays.toString(sol.mergeSort(arr)));
	}
}
