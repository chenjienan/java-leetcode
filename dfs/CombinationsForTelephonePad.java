package dfs;
import java.util.*;

public class CombinationsForTelephonePad {
  public String[] combinations(int number) {

    char[] digitArray = Integer.toString(number).toCharArray();
    Map<Character, String> phoneMap = new HashMap<>();
    phoneMap.put('0', "");
    phoneMap.put('1', "");
    phoneMap.put('2', "abc");
    phoneMap.put('3', "def");
    phoneMap.put('4', "ghi");
    phoneMap.put('5', "jkl");
    phoneMap.put('6', "mno");
    phoneMap.put('7', "pqrs");
    phoneMap.put('8', "tuv");
    phoneMap.put('9', "wxyz");

    List<String> res = new ArrayList<>();
    StringBuilder prefix = new StringBuilder();

    DFS(digitArray, phoneMap, 0, prefix, res);

    String[] resArray = new String[res.size()];
    resArray = res.toArray(resArray);
    return resArray;
  }

  private void DFS(char[] digitArray, Map<Character, String> phoneMap, int level, StringBuilder prefix, List<String> res) {

    if (level == digitArray.length) {
      res.add(prefix.toString());
      return;
    }

    String str = phoneMap.get(digitArray[level]);
    if (str.isEmpty()) {
      DFS(digitArray, phoneMap, level+1, prefix, res);
    } else {
      for (int j = 0; j < str.length(); j++) {
        prefix.append(str.charAt(j));
        DFS(digitArray, phoneMap, level+1, prefix, res);
        prefix.deleteCharAt(prefix.length() - 1);
      }
    }
  }
  
  public static void main(String[] args) {
    CombinationsForTelephonePad sol = new CombinationsForTelephonePad();
    System.out.println(sol.combinations(231));
  }
}



