package heap;
import java.util.*;

public class MedianTracker {

  private Queue<Integer> maxHeap;
  private Queue<Integer> minHeap;

  public MedianTracker() {
    // add new fields and complete the constructor if necessary.
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }
  
  public void read(int value) {
    // write your implementation here.
    if (maxHeap.isEmpty() || value <= maxHeap.peek()) {
      maxHeap.offer(value);
    } else {
      minHeap.offer(value);
    }
    balance();
  }
  
  public Double median() {
    // write your implementation here.
    if (maxHeap.isEmpty()) {
      return null;
    }

    // even number in the stream
    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    return maxHeap.peek() / 1.0;
  }

  private void balance() {
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    } else if (maxHeap.size() - 1 > minHeap.size()) {
      minHeap.offer(maxHeap.poll());
    } 
  }

  public static void main(String[] args) {
    MedianTracker tracker = new MedianTracker();
    tracker.read(1);
    tracker.read(2);
    tracker.read(3);
    tracker.read(10);
    System.out.println(tracker.median());
  }
}
