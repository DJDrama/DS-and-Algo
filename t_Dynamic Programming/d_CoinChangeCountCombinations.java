import java.util.Arrays;

public class CoinChangeCountCombinations {
    // {1, 2, 3}, sum=4 --> 4 (1+1+1+1), (2+2), (1+3), (1+1+2) (4 possible ways)
    // {2, 5, 3, 6}, sum=10 --> 5 (2+2+2+2+2), (2+3+2+3), (5+5), (6+2+2), (5+2+3)
    int getCount(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; //base case

        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[sum];
    }
    
}

class Main {
    public static void main(String[] args) {
        CoinChangeCountCombinations c = new CoinChangeCountCombinations();
        int[] coins = {1, 2, 3};
        int sum = 4;

        // dp = {0, 0, 0, 0, 0}
        // dp = {1, 0, 0, 0, 0}
        // when coin=1
        //      when j=1
        //          dp[1] += dp[1-1] = 1
        //          {1, 1, 0, 0, 0}
        //      when j=2
        //          dp[2] += dp[2-1] = 1
        //          {1, 1, 1, 0, 0}
        //      when j=3
        //          dp[3] += dp[3-1] = 1
        //          {1, 1, 1, 1, 0}
        //      when j=4
        //          dp[4] += dp[4-1] = 1
        //          {1, 1, 1, 1, 1}
        // when coin=2
        //      when j=2
        //          dp[2] += dp[2-2] = 2
        //          {1, 1, 2, 1, 1}
        //      when j=3
        //          dp[3] += dp[3-2] = 2
        //          {1, 1, 2, 2, 1}
        //      when j=4
        //          dp[4] += dp[4-2] = 3
        //          {1, 1, 2, 2, 3}
        // when coin=3
        //      when j=3
        //          dp[3] += dp[3-3] = 3
        //          {1, 1, 2, 3, 3}
        //      when j=4
        //          dp[4] += dp[4-3] = 4
        //          {1, 1, 2, 3, 4}
        //
        // RETURN dp[sum(4)] = 4
        System.out.println(c.getCount(coins, sum)); // 4
    }
}
