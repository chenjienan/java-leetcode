package dfs;
import java.util.*;

public class AllSubSetI {

    public static List<String> subSets(String set) {
        
        List<String> res = new ArrayList<>();

        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder("");
        char[] input = set.toCharArray();
        DFS(input, 0, sb, res);

        return res;
    }

    private static void DFS(char[] input, int index, StringBuilder prefix, List<String> res) {
        if (index == input.length) {
            res.add(prefix.toString());     // O(n)
            return;
        }

        // case 1: add current char at index
        prefix.append(input[index]);
        DFS(input, index + 1, prefix, res);
        prefix.deleteCharAt(prefix.length() - 1);

        // case 2: not to add current char at index
        DFS(input, index + 1, prefix, res);
    }

	public static void main(String[] args)
	{
        String str = null;
        List<String> res = subSets(str);
        System.out.println(res);
	}
}
