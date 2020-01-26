package sorting;
import java.util.*;

class RainbowSort {

    public int[] rainbowSort(int[] arr) {
        if (arr == null || arr.length <= 1){
            return arr;
        }
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;

        while (mid <= right) {
            if (arr[mid] == -1) {
                swap(arr, left++, mid++);
            } else if (arr[mid] == 0) {
                mid++;
            } else {
                swap(arr, mid, right--);
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	public static void main(String[] args)
	{
        int[] arr = new int[] {1,0,0,-1,0,1,0,-1,-1};
        RainbowSort sol = new RainbowSort();
        System.out.println(Arrays.toString(sol.rainbowSort(arr)));
	}
}
