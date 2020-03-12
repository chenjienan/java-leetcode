package hashtable;
import java.util.*;


class TwoSum {
  public List<List<Integer>> twoSum(int[] array, int target) {
	
    Map<Integer, List<Integer>> lookup = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < array.length; i++) {
      if (lookup.containsKey(array[i])) {
        List<Integer> idxList = lookup.get(array[i]);
        for (Integer j : idxList) {
          res.add(Arrays.asList(j, i));
        }
      }
      List<Integer> idxList = lookup.get(target - array[i]);
      if (idxList == null) {
        idxList = new ArrayList<>();
      }
      idxList.add(i);		
      lookup.put(target - array[i], idxList);
    }
    return res;
  }

  public List<List<Integer>> twoSumDistinct(int[] array, int target) {
	
    Map<Integer, Integer> lookup = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> used = new HashSet<>();

    for (int i = 0; i < array.length; i++) {
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

  public static void main(String[] args) {
    int[] A = {2, 1, 3, 2, 4, 3, 4, 2};
    //         0  1  2  3  4  5  6  7
    TwoSum sol = new TwoSum();
    // System.out.println(sol.twoSum(A, 6));
    System.out.println(sol.twoSumDistinct(A, 6));
  }
}