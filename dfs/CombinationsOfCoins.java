package dfs;
import java.util.*;

public class CombinationsOfCoins {

    public List<List<Integer>> combinations(int target, int[] coins) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curCombo = new ArrayList<>();
        DFS(coins, target, 0, curCombo, res);
        return res;
    }

    
    private void DFS(int[] coins, int moneyLeft, int index, List<Integer> coinCombo, List<List<Integer>> res) {
        if (index == coins.length - 1) {
            if (moneyLeft % coins[coins.length - 1] == 0) {
                coinCombo.add(moneyLeft / coins[coins.length - 1]);
                res.add(new ArrayList<Integer>(coinCombo));
                coinCombo.remove(coinCombo.size() - 1);
            }
            return;
        }

        int maxNumber = moneyLeft / coins[index];
        for (int i = 0; i <= maxNumber; i++) {
            coinCombo.add(i);
            DFS(coins, moneyLeft - i * coins[index], index + 1, coinCombo, res);
            coinCombo.remove(coinCombo.size() - 1);
        }
    }
	public static void main(String[] args)
	{
        int[] coins = new int[] {34, 31, 29, 16, 2};
        int target = 10;

        CombinationsOfCoins solution = new CombinationsOfCoins();
        System.out.println(solution.combinations(target, coins));
	}
}
