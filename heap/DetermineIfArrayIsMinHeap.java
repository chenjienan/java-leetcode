package heap;


class DetermineIfArrayIsMinHeap {
    public boolean isMinHeap(int[] array) {
        
        if (array == null || array.length == 0) {
            return true;
        }

        int index = 0;
        while (index <= array.length / 2 - 1) {
            int leftIdx = index * 2 + 1;
            int rightIdx = index * 2 + 2;

            if (leftIdx < array.length && array[index] > array[leftIdx] ||
                rightIdx < array.length && array[index] > array[rightIdx]) {
                return false;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {

    }
  }
  