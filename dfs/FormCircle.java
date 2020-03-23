package dfs;
import java.util.*;

public class FormCircle {
  public boolean canFormCircle(String[] array) {
    
    if (array == null || array.length == 0) {
      return false;
    }

    Set<List<String>> seen = new HashSet<>();
    List<String> stringList = new ArrayList<>(Arrays.asList(array));
    boolean[] res = {false};
    dfs(stringList, 0, seen, res);
    return res[0];
  }

  private void dfs(List<String> stringList, int level, Set<List<String>> seen, boolean[] res) {

    if (canChain(stringList)) {
      res[0] = true;
      return;
    }

    if (level == stringList.size()) {
      return;
    }

    for (int i = level; i < stringList.size(); i++){
      swap(stringList, i, level);
      if (!seen.contains(stringList)) {
        seen.add(stringList);
        dfs(stringList, level + 1, seen, res);
        seen.remove(stringList);
      }
      swap(stringList, i, level);
    }
  }

  private void swap(List<String> array, int i, int j) {
    String tmp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, tmp);
  }

  private boolean canChain(List<String> array) {
    for (int i = 0; i < array.size() - 1; i++) {
      String first = array.get(i);
      String second = array.get(i + 1);
      
      if (first.charAt(first.length() - 1) != second.charAt(0)) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    String[] a = {"aaa", "bbb", "baa", "aab"};
    FormCircle sol = new FormCircle();
    System.out.println(sol.canFormCircle(a));
  }
}
