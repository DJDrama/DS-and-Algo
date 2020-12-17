public class PalindromePartitioning {
    // "abbac" --> 1 (abba)
    // "abcde" --> 4
    // "aaaa" --> 0
    // "abbabbc" --> 2 (bbabb)
    private boolean isPalindrome(String str, int l, int r){
        while(l<r){
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    int palindromePart(String str){
        int n=str.length();
        int[][] dp = new int[n][n];
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (isPalindrome(str, i, j)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}

class Main {
    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        String str = "abbabbc";
        System.out.println(p.palindromePart(str));
    }
}