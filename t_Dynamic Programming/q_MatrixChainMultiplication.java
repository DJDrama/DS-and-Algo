public class MatrixChainMultiplication {
    // 3*4 * 4*5 == 3*5 (number of integer multiplications = 3*4*5)
    // {2, 1, 3, 4} --> 20 (0 + 1*3*4 + 2*1*4)
    // {2, 1, 3} --> 6
    // {3, 4} --> 0
    int matrixChainOrderRec(int[] arr, int i, int j) {
        if (i + 1 == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int count = matrixChainOrderRec(arr, i, k)
                    + matrixChainOrderRec(arr, k, j)
                    + arr[i] * arr[k] * arr[j];
            min = Math.min(min, count);
        }
        return min;
    }

    int matrixChainOrderDp(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = 0;

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
            }
        }
        return dp[0][n - 1];
    }
}

class Main {
    public static void main(String[] args) {
        MatrixChainMultiplication m = new MatrixChainMultiplication();
        int[] arr = {2, 1, 3, 4};
        System.out.println(m.matrixChainOrderRec(arr, 0, arr.length - 1)); // 20
        System.out.println(m.matrixChainOrderDp(arr)); // 20
    }
}