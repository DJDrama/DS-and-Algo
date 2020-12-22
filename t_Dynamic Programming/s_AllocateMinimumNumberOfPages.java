public class AllocateMinimumNumberOfPages {
    // {10, 20, 30, 40}, k=2 --> 60
    // {10, 20, 30}, k=1 --> 60
    // {10, 5, 30, 1, 2, 5, 10, 10}, k=3 --> 30

    /**
     * Recursive
     **/
    int minPages(int[] arr, int n, int k) {
        if (k == 1)
            return sum(arr, 0, n - 1);
        if (n == 1)
            return arr[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(
                    res,
                    Math.max(minPages(arr, i, k - 1), sum(arr, i, n - 1)));
        }
        return res;
    }

    private int sum(int[] arr, int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * DP
     **/
    // when {10, 20, 30, 40}, k=2
    // 0  0  0  0   0
    // 0 10 30 60 100
    // 0 10 20 30  60

    // O(k*n^3) time complexity
    int minPagesDp(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++)
            dp[1][i] += dp[1][i - 1] + arr[i - 1];
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int res = Integer.MAX_VALUE;
                for (int p = 1; p < j; p++) {
                    res = Math.min(res,
                            Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
                }
                dp[i][j] = res;
            }
        }
        return dp[k][n];
    }


}

class Main {
    public static void main(String[] args) {
        AllocateMinimumNumberOfPages a = new AllocateMinimumNumberOfPages();
        int[] arr = {10, 20, 30, 40};
        int k = 2;

        int res = a.minPages(arr, arr.length, k);
        System.out.println(res);

        System.out.println(a.minPagesDp(arr, arr.length, k));

    }
}
