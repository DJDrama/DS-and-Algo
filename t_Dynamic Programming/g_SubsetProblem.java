public class SubsetProblem {
    //Subset Problem
    // arr ={2, 5, 3}, sum=5 --> 2 {2, 3}, {5}

    // O(2^n) time complexity
    int countSubsetNaive(int[] arr, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;
        return countSubsetNaive(arr, n - 1, sum)
                + countSubsetNaive(arr, n - 1, sum - arr[n - 1]);
    }

    /* {2, 3, 5}, sum=5
        1 0 0 0 0 0
        1 0 1 0 1 0
        1 0 1 1 1 1
        1 0 1 1 1 2
     */
    int countSubsetDp(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for(int i=0; i<=n; i++)
            dp[i][0]=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(j<arr[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-arr[i-1]];
            }
        }
        return dp[n][sum];
    }
}

class Main {
    public static void main(String[] args) {
        SubsetProblem s = new SubsetProblem();
        int[] arr = {2, 3, 5};
        int sum = 5;

        // n=3
        // countSubsetNaive(arr, 2, 5) + countSubsetNaive(arr, 2, 5-3)
        // 1) countSubsetNaive(arr, 2, 5)
        //    --> csn(arr, 1, 5) + csn(arr, 1, 5-5)
        //        --> csn(arr, 0, 5) + csn(0, 0, 3) + csn(arr, 0, 0) + csn(arr, 0, -2)
        //            --> 0 + 0 + 1 + 0 = 1
        // 2) countSubsetNaive(arr, 2, 5-3)
        //    --> csn(arr, 1, 2) + csn(arr, 2, -3)
        //    --> csn(arr, 0, 2) + csn(arr, 0, 2-2) + csn(arr, 1, -3) + csn(arr, 1, -8)
        //    --> 0 + 1 + 0 + 0 = 1
        // 1 + 1 = 2
        System.out.println(s.countSubsetNaive(arr, arr.length, sum)); //2

        System.out.println(s.countSubsetDp(arr, arr.length, sum));
    }
}
