package dfs;
import java.util.*;

public class AllSubSetWithSizeK {
  public List<String> subSetsIIOfSizeK(String set, int k) {
    List<String> res = new ArrayList<>();

    if (set.isEmpty() && k != 0) {
      return res;
    }
    
    if (set.isEmpty()) {
      res.add("");
      return res;
    }

    StringBuilder prefix = new StringBuilder();
    char[] charArr = set.toCharArray();
    Arrays.sort(charArr);
    helper(charArr, k, 0, prefix, res);
    return res;
  }

  private void helper(char[] set, int k, int level, StringBuilder prefix, List<String> res) {
    if (prefix.length() == k) {
      res.add(prefix.toString());
      return;
    }

    if (level == set.length) {
      return;
    }

    prefix.append(set[level]);
    helper(set, k, level + 1, prefix, res);
    prefix.deleteCharAt(prefix.length() - 1);

    while (level < set.length - 1 && set[level] == set[level + 1]) {
      level++;
    }
    helper(set, k, level + 1, prefix, res);
  }
}
