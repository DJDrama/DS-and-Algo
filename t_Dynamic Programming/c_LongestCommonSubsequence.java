import java.util.Arrays;

public class LongestCommonSubsequence {
    /**
     * Longest Common Subsequence
     **/
    // ABCDGH, AEDFHR = 3 ("ADH")
    // AGGTAB, GXTXAYB = 4 ("GTAB")
    // XYZ, XYZ = 3 ("XYZ")
    // ABC, XY = 0

    // O(m*n) time complexity
    // O(m*n) space complexity
    int lcsUsingMemoization(String s1, String s2, int m, int n, int[][] memo) {
        if (memo[m][n] != -1)
            return memo[m][n];
        if (m == 0 || n == 0)
            memo[m][n] = 0;
        else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1))
                memo[m][n] = 1 + lcsUsingMemoization(s1, s2, m - 1, n - 1, memo);
            else
                memo[m][n] = Math.max(lcsUsingMemoization(s1, s2, m - 1, n, memo),
                        lcsUsingMemoization(s1, s2, m, n - 1, memo));
        }
        return memo[m][n];
    }

    int lcsUsingTabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}

class Main {
    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        // Memoization
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] ints : memo)
            Arrays.fill(ints, -1);
        System.out.println(l.lcsUsingMemoization(s1, s2, s1.length(), s2.length(), memo));

        // Tabulation
        System.out.println(l.lcsUsingTabulation(s1, s2));
    }
}
