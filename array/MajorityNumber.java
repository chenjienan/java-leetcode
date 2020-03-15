package array;
import java.util.*;


public class MajorityNumber {
  public List<Integer> majority(int[] array, int k) {
    
    Map<Integer, Integer> lookup = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    // Step 1 
    for (int num : array) {
      Integer numCount = lookup.get(num);
      if (numCount != null) {
        numCount++;
        lookup.put(num, numCount);
      } else {
        if (lookup.size() < k - 1) {
          lookup.put(num, 1);
        } else {
          for (Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
            Integer curCount = entry.getValue() - 1;
            if (curCount == 0) {
              lookup.remove(entry.getKey());
            }
            lookup.put(entry.getKey(), curCount);            
          }
        }        
      }
    }

    // Step 2
    for (Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
      int count = 0;
      for (int num : array) {
        if (num == entry.getKey()) {
          count++;
        }
      }

      if (count > array.length / k) {
        res.add(entry.getKey());
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 1, 2, 3, 3, 1};
    MajorityNumber sol = new MajorityNumber();
    System.out.println(sol.majority(A, 4));

  }
}
