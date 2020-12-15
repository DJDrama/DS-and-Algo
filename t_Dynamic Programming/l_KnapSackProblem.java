public class KnapSackProblem {
    // 0-1 Knapsack Problem
    // val[]={10, 40, 30, 50} , wt[]={5, 4, 6, 3}, w=10
    // --> 90
    // val[]={60, 100, 120} , wt[]={10, 20, 30}, w=50
    // --> 220
    int knapsackRecursive(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] > W)
            return knapsackRecursive(W, wt, val, n - 1);
        else
            return Math.max(
                    knapsackRecursive(W, wt, val, n - 1),
                    val[n - 1] + knapsackRecursive(W - wt[n - 1], wt, val, n - 1));
    }

    /*
      0  1  2  3  4  5  6  7  8  9 10
    0 0  0  0  0  0  0  0  0  0  0  0
    1 0  0  0  0  0 10 10 10 10 10 10
    2 0  0  0  0 40 40 40 40 40 50 50
    3 0  0  0  0 40 40 40 40 40 50 70
    4 0  0  0 50 50 50 50 90 90 90 90
    */
    int knapsackDp(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(
                            val[i-1] + dp[i-1][j-wt[i-1]],
                            dp[i-1][j]
                    );
            }
        }
        return dp[n][W];
    }
}

class Main {
    public static void main(String[] args) {
        KnapSackProblem k = new KnapSackProblem();
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        int W = 10;
        System.out.println(k.knapsackRecursive(W, wt, val, 4)); // 90

        System.out.println(k.knapsackDp(W, wt, val, 4)); // 90


    }
}
