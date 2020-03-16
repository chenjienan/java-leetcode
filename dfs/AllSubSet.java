package dfs;
import java.util.*;

public class AllSubSet {

    public List<String> subSets1(String set) {
        
        List<String> res = new ArrayList<>();

        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder("");
        char[] input = set.toCharArray();
        DFS(input, 0, sb, res);

        return res;
    }

    private void DFS(char[] input, int index, StringBuilder prefix, List<String> res) {
        if (index == input.length) {
            res.add(prefix.toString());     // O(n)
            return;
        }

        // case 1: add current char at index
        prefix.append(input[index]);
        prefix.append("_");
        DFS(input, index + 1, prefix, res);
        prefix.deleteCharAt(prefix.length() - 1);

        // case 2: not to add current char at index
        DFS(input, index + 1, prefix, res);
    }


    public List<String> subSets2(String set) {
        List<String> res = new ArrayList<>();

        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder("");
        char[] input = set.toCharArray();
        Arrays.sort(input);
        DFS2(input, 0, sb, res);

        return res;
    }

    private void DFS2(char[] input, int index, StringBuilder prefix, List<String> res) {
        if (index == input.length) {
            res.add(prefix.toString());     // O(n)
            return;
        }

        // case 1: add current char at index
        prefix.append(input[index]);
        DFS2(input, index + 1, prefix, res);
        prefix.deleteCharAt(prefix.length() - 1);

        // case 2: skip all duplicates
        while (index < input.length - 1 && input[index] == input[index + 1]) {
            index++;
        }
        DFS2(input, index + 1, prefix, res);
    }

	public static void main(String[] args)
	{
        String str = "abc";
        // String str = "abab";
        AllSubSet solution = new AllSubSet();
        System.out.println(solution.subSets1(str));

        // System.out.println(solution.subSets2(str));
	}
}
