package hashtable;
import java.util.*;


public class ThreeSum {
  public List<List<Integer>> allTriples(int[] array, int target) {
    Arrays.sort(array); // sort the array to avoid duplicate triples

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < array.length - 2; i++) {
      if (i == 0 || array[i] != array[i - 1]){  // skip duplicates
        List<List<Integer>> twoSumRes = twoSum(array, i + 1, array.length, target - array[i]);
        if (twoSumRes.size() != 0) {
          for (List<Integer> ls : twoSumRes) {
            List<Integer> newLs = new ArrayList<>(ls);
            newLs.add(array[i]);
            res.add(newLs);
          }
        }
      }      
    }
    return res;
  }

  private List<List<Integer>> twoSum(int[] array, int start, int end, int target) {
    Map<Integer, Integer> lookup = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> used = new HashSet<>();

    for (int i = start; i < end; i++) {
      if (lookup.containsKey(array[i])) {
        int idx = lookup.get(array[i]);
        int idxVal = array[idx];
        if (!used.contains(idxVal)) {
          used.add(idxVal);
          used.add(array[i]);
          res.add(Arrays.asList(idxVal, array[i]));
        }        
      }

      if (!lookup.containsKey(target - array[i])) {
        lookup.put(target - array[i], i);
      }
    }
    return res;
  }
}
