public class OptimalStrategyForAGame {
    // Optimal Strategy for a game
    // 20, 5, 4, 6 --> 25 (20+5)
    // 2, 3, 15, 7 --> 17 (2+17)

    // O(n^2) time complexity
    // O(n^2) space complexity
    int os(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // 0 20  5  6
        // 0  0  5  6
        // 0  0  0  6
        // 0  0  0  0
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }

        // 0 20  5 25 <-- dp[0][n-1]
        // 0  0  5  6
        // 0  0  0  6
        // 0  0  0  0
        for (int gap = 3; gap < n; gap += 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = gap + i;
                dp[i][j] = Math.max(
                        arr[i] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]),
                        arr[i] + Math.min(dp[i + 1][j - 1], dp[i][j - 2])
                );
            }
        }
        return dp[0][n - 1]; // 25
    }
}

class Main {
    public static void main(String[] args) {
        OptimalStrategyForAGame o = new OptimalStrategyForAGame();
        int[] arr = {20, 5, 4, 6};
        System.out.println(o.os(arr)); // 25
    }
}