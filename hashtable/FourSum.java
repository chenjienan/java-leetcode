package hashtable;
import java.util.*;


public class FourSum {
  public boolean exist(int[] array, int target) {
	
    Arrays.sort(array);
    List<List<Integer>> res = new ArrayList<>();
    
    for (int i = 0; i < array.length - 3; i++) {
      if(i == 0 || array[i] != array[i - 1]) {
        for (int j = i + 1; j < array.length - 2; j++) {
          if (j == i + 1 || array[j] != array[j - 1]) {
            int twoSumTarget = target - array[i] - array[j];
            List<List<Integer>> twoSumRes = twoSum(array, j + 1, twoSumTarget);
            if (twoSumRes.size() != 0) {
              for (List<Integer> ls : twoSumRes) {
                List<Integer> newLs = new ArrayList<>(ls);
                newLs.add(array[i]);
                newLs.add(array[j]);
                res.add(newLs);
              }
            }
          }			
        }
      }	
    }
    return res.size() > 0;
  }
  
  private List<List<Integer>> twoSum(int[] array, int start, int target) {
    Map<Integer, Integer> lookup = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> used = new HashSet<>();

    for (int i = start; i < array.length; i++) {
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
    int[] A = {3,1,6,2,5,9,4};

    FourSum sol = new FourSum();
    System.out.println(sol.exist(A, 22));
  }
}
