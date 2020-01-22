package string;

public class ReOrderArray {

    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] arr, int left, int right) {
        int length = right - left + 1;

        if (length <= 2){
            return;
        }

        int mid = left + length / 2;
        int leftMid = left + length / 4;
        int rightMid = left + length * 3 / 4;

        // exchange [leftMid, mid-1] with [mid, rightMid-1]
        reverse(arr, leftMid, mid - 1);
        reverse(arr, mid, rightMid - 1);
        reverse(arr, leftMid, rightMid - 1);

        // half of the left partition's size = leftMid - left
        reorder(arr, left, left + (leftMid - left) * 2 - 1);
        reorder(arr, left + (leftMid - left) * 2, right);
    }

    private void reverse(int[] arr, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            swap(arr, left++, right--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};

        ReOrderArray sol = new ReOrderArray();
        System.out.println(sol.reorder(arr));
    }
}
  