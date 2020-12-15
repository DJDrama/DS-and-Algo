public class MinimumCoins {
    // Minimum coins to make a value
    // coins[] = {25, 10, 5}, val=30 --> 2 (25, 5)
    // coins[] = {9, 6, 5, 1}, val=11 --> 2 (5, 6)
    int minCoinsRecursive(int[] coins, int n, int val) {
        if (val == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                int subRes = minCoinsRecursive(coins, n, val - coins[i]);
                if (subRes != Integer.MAX_VALUE)
                    res = Math.min(res, subRes + 1);
            }
        }
        return res;
    }

    // O(n*val) time complexity
    // O(val) space complexity
    int minCoinsDp(int[] coins, int n, int val) {
        int[] dp = new int[val + 1];
        for (int i = 1; i <= val; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int subRes = dp[i - coins[j]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < dp[i])
                        dp[i] = subRes + 1;
                }
            }
        }
        return dp[val];
    }
}

class Main {
    public static void main(String[] args) {
        MinimumCoins m = new MinimumCoins();
        int[] coins = {25, 10, 5};
        System.out.println(m.minCoinsRecursive(coins, 3, 30)); // 2
        System.out.println(m.minCoinsDp(coins, 3, 30)); // 2
    }
}
