package dfs;
import java.util.*;

public class AllPermutationsI {
    
    public List<String> permutations(String input) {
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

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }


    public static void main(String[] args)
	{
        String str = "abc";
        AllPermutationsI solution = new AllPermutationsI();
        System.out.println(solution.permutations(str));
	}
}
