package hashtable;

import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		int[] a = new int[]{3,5,3,2,4,4};
		System.out.println(allPairs(a, 7));
	}
	
	public static List<List<Integer>> allPairs(int[] array, int target) {
    Map<Integer, Integer> lookup = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < array.length; i++) {
      if (lookup.containsKey(array[i])) {
        List<Integer> pair = new ArrayList<>();
        pair.add(lookup.get(array[i]));
        pair.add(i);
        res.add(pair);
      }
      lookup.put(target - array[i], i);
    }

    return res;
  }
}