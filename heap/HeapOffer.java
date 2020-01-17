package heap;

public class HeapOffer {

    public int[] offerHeap(int[] array, int ele) {
    
        int index = array.length - 1;
        array[index] = ele;
        int parentIdx = (index - 1) / 2;
        while (parentIdx >= 0 && array[parentIdx] > array[index]) {
          swap(array, parentIdx, index);
          index = parentIdx;
          parentIdx = (index - 1) / 2;
        }
        return array;
      }
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
	public static void main(String[] args)
	{
		
	}
}
