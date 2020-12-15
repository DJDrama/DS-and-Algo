public class MaximumCuts {
    // Maximum Cuts
    // n=5, a=1,b=2,c=3 --> 5 ( 1*5 )
    // n=23, a=12,b=11,c=13 --> 2 (12 + 11)
    // n=3, a=2, b=4, c=2 --> -1 (can't make 3)

    // O(3^n) time complexity
    int maxCutsRecursive(int n, int a, int b, int c) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int res = Math.max(
                Math.max(maxCutsRecursive(n - a, a, b, c),
                        maxCutsRecursive(n - b, a, b, c)),
                maxCutsRecursive(n - c, a, b, c));
        if (res == -1)
            return res;
        return res + 1;
    }

    // O(n) time complexity
    // O(n) space complexity
    int maxCutsDp(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0)
                dp[i] = Math.max(dp[i], dp[i - a]);
            if (i - b >= 0)
                dp[i] = Math.max(dp[i], dp[i - b]);
            if (i - c >= 0)
                dp[i] = Math.max(dp[i], dp[i - c]);
            if (dp[i] != -1)
                dp[i]++;
        }
        return dp[n];
    }
}

class Main {
    public static void main(String[] args) {
        MaximumCuts m = new MaximumCuts();
        System.out.println(m.maxCutsRecursive(23, 12, 11, 13)); // 2
        System.out.println(m.maxCutsRecursive(3, 2, 4, 2)); // -1

        System.out.println(m.maxCutsDp(23, 12, 11, 13)); // 2
        System.out.println(m.maxCutsDp(3, 2, 4, 2)); // -1
    }
}
