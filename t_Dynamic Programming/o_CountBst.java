public class CountBst {
    // count BST with n keys (all keys should be distinct)
    // n=0 --> 1 (empty bst)
    // n=1 --> 1 (1)
    // n=2 --> 2 (1+1)
    // n=3 --> 5 (2+1+2)
    // n=4 --> 14 (5+2+2+5) (n=3 + n=2 + n=2 + n=3)
    // n=5 --> 14 + 5 + (2+2) + 5 + 14 = 42

    // 1 1 2 5 14 42 ...
    int countBstDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    // Catalan number: 2nCn/(n+1)
    // O(n) time complexity, O(1) space complexity
    int countBstCatalanNumber(int n) {
        return binomialCoefficient(2 * n, n) / (n + 1);
    }

    // nCk
    private int binomialCoefficient(int n, int k) {
        int res = 1;

        if (k > n - k) // nCk == nCn-k
            k = n - k;

        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        CountBst c = new CountBst();

        int n = 5;
        //dp[0]=1
        //dp[1] += dp[0]*dp[0] = 1
        //dp[2] += dp[0]*dp[1] + dp[1]*dp[0] = 1 + 1 = 2
        //dp[3] += dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0] = 2+1+2=5

        System.out.println(c.countBstDp(n)); // 42

        System.out.println(c.countBstCatalanNumber(n)); // 42
    }
}