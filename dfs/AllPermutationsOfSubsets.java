package dfs;
import java.util.*;


public class AllPermutationsOfSubsets {
  public List<String> allPermutationsOfSubsets(String set) {
    

    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }

    char[] charArr = set.toCharArray();
    dfs(charArr, 0, res);
    return res;
  }

  private void dfs(char[] charArr, int curIdx, List<String> res) {

    res.add(new String(charArr, 0, curIdx));

    for (int i = curIdx; i < charArr.length; i++) {
      swap(charArr, i, curIdx);
      dfs(charArr, curIdx + 1, res);
      swap(charArr, i, curIdx);
    }
  }

  private void swap(char[] s, int i, int j) {
    char tmp = s[i];
    s[i] = s[j];
    s[j] = tmp;
  }
}
