package heap;
import java.util.*;

public class HeapSort {
    public int[] heapsort(int[] array) {
      
      if (array == null || array.length == 0) {
        return array;
      }
      
      
      int size = array.length;

      // heapify O(n)
      for (int i = size / 2 - 1; i >= 0; i--) {
          percolateDown(array, i, size);
      }

      // n * log n
      for (int i = 0; i < size; i++) {
          percolateDown(array, 0, size - i);
          int curIdx = size - i - 1;
          swap(array, 0, curIdx);
      }
      return array;
    }

    private void percolateDown(int[] array, int index, int size) {
        while (index <= size / 2 - 1) {
            int leftChildIdx = index * 2 + 1;
            int rightChildIdx = index * 2 + 2;
            int swapCandidateIdx = leftChildIdx;

            if (rightChildIdx <= size - 1 && array[leftChildIdx] < array[rightChildIdx]){
                swapCandidateIdx = rightChildIdx;
            }

            if (array[index] < array[swapCandidateIdx]) {
                swap(array, index, swapCandidateIdx);
            } else {
                break;
            }
            index = swapCandidateIdx;
        }
    }

    private void swap(int[] array, int i ,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args){
        int[] arr = new int[]{7,5,3,1,2,8};
        HeapSort solution = new HeapSort();
        System.out.print(Arrays.toString(solution.heapsort(arr)));
    }
}