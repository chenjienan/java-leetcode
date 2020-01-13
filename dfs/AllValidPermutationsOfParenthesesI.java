package dfs;
import java.util.*;

public class AllValidPermutationsOfParenthesesI {

    public static List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();

        if (n <= 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder("");
        DFS(n, 0, 0 , sb, res);

        return res;
    }

    private static void DFS(int pairs, int left, int right, StringBuilder strPrefix, List<String> res) {
        if (left + right == 2 * pairs) {
            res.add(strPrefix.toString());
            return;
        }

        if (left < pairs) {
            strPrefix.append("(");
            DFS(pairs, left + 1, right, strPrefix, res);
            strPrefix.deleteCharAt(strPrefix.length() - 1);
        }

        if (right < left) {
            strPrefix.append(")");
            DFS(pairs, left, right + 1, strPrefix, res);
            strPrefix.deleteCharAt(strPrefix.length() - 1);
        }
    }
	public static void main(String[] args)
	{
        int n = 2;
        System.out.println(validParentheses(n));
	}
}
