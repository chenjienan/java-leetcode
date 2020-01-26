package stackqueue;

class MyCircularDeque {

  private int[] array;
  private int size;
  private int frontIdx;   // add item to the left frontIdx - 1
  private int rearIdx;    // add item to the right rearIdx + 1

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque(int k) {
    array = new int[k + 2];
    size = 0;
    frontIdx = 0;
    rearIdx = 0;
  }
  
  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
      
    if (isFull()) {
      return false;
    }

    if (frontIdx == 0){
      frontIdx = array.length - 1;
    }

    array[frontIdx--] = value;    
    size++;
    return true;
  }
  
  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }

    if (rearIdx == array.length - 1) {
      rearIdx = 0;
    }
    
    array[rearIdx++] = value;  
    size++;
    return true;
  }
  
  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }

    frontIdx--;
    size--;
    return true;
  }
  
  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }

    rearIdx++;
    size--;
    return true;
  }
  
  /** Get the front item from the deque. */
  public int getFront() {
    return array[frontIdx + 1];
  }
  
  /** Get the last item from the deque. */
  public int getRear() {
    return array[rearIdx - 1];
  }
  
  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return size == 0;
  }
  
  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return size == array.length - 2;
  }

  public static void main(String[] args) {
    MyCircularDeque obj = new MyCircularDeque(10);
    boolean param_1 = obj.insertFront(1);
    boolean param_2 = obj.insertLast(2);
    boolean param_3 = obj.deleteFront();
    boolean param_4 = obj.deleteLast();
    int param_5 = obj.getFront();
    int param_6 = obj.getRear();
    boolean param_7 = obj.isEmpty();
    boolean param_8 = obj.isFull();

    
  }
}

/**
* Your MyCircularDeque object will be instantiated and called as such:
* MyCircularDeque obj = new MyCircularDeque(k);
* boolean param_1 = obj.insertFront(value);
* boolean param_2 = obj.insertLast(value);
* boolean param_3 = obj.deleteFront();
* boolean param_4 = obj.deleteLast();
* int param_5 = obj.getFront();
* int param_6 = obj.getRear();
* boolean param_7 = obj.isEmpty();
* boolean param_8 = obj.isFull();
*/