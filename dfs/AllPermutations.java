package dfs;
import java.util.*;

public class AllPermutations {
    
    public List<String> permutations1(String input) {
        List<String> res = new ArrayList<>();
        if (input.length() == 0) {
            res.add(new String(""));
            return res;
        }
        
        char[] charArray = input.toCharArray();
        DFS(charArray, 0, res);

        return res;
    }
    
    private void DFS(char[] charArray, int index, List<String> res) {
        if (index == charArray.length - 1) {
            res.add(new String(charArray));
            return;
        }

        for (int i = index; i < charArray.length; ++i) {
            swap(charArray, i, index);
            DFS(charArray, index + 1, res);
            swap(charArray, i, index);
        }
    }

    public List<String> permutations2(String input) {
        List<String> res = new ArrayList<>();
        if (input.length() == 0) {
            res.add(new String(""));
            return res;
        }
        
        char[] charArray = input.toCharArray();
        DFS2(charArray, 0, res);

        return res;
    }

    private void DFS2(char[] charArray, int index, List<String> res) {
        if (index == charArray.length - 1) {
            res.add(new String(charArray));
            return;
        }

        HashSet<Character> used = new HashSet<>();
        for (int i = index; i < charArray.length; ++i) {
            if (!used.contains(charArray[i])){
                used.add(charArray[i]);

                swap(charArray, i, index);
                DFS2(charArray, index + 1, res);
                swap(charArray, i, index);
            }
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }


    public static void main(String[] args)
	{
        String str = "abbbc";
        AllPermutations solution = new AllPermutations();
        System.out.println(solution.permutations2(str));
	}
}
