import static java.lang.Integer.MAX_VALUE;

public class MinimumJumps {
    // Min jumps to reach end
    // {3, 4, 2, 1, 2, 1} --> 2 (1, 4)
    // {4, 1, 5, 3, 1, 3, 2, 1, 8} --> 3 (4, 1, 3) or (2, 5, 1)

    int minJumpsRecursive(int[] arr, int n) {
        if (n == 1)
            return 0;
        int res = MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (i + arr[i] >= n - 1) {
                int subRes = minJumpsRecursive(arr, i + 1);
                if (subRes != MAX_VALUE) {
                    res = Math.min(res, subRes + 1); // 1 = jump
                }
            }
        }
        return res;
    }

    int minJumpsDp(int[] arr, int n) {
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && dp[j] != MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}

class Main {
    public static void main(String[] args) {
        MinimumJumps m = new MinimumJumps();
        int[] arr = {3, 4, 2, 1, 2, 1};

        System.out.println(m.minJumpsRecursive(arr, arr.length)); // 2

        System.out.println(m.minJumpsDp(arr, arr.length));

    }
}
