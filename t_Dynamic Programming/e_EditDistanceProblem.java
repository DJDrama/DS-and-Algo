public class EditDistanceProblem {
    // Edit Distance Problem
    // minimum number of conversion
    // cat, cut --> 1
    // saturday, sunday --> 3
    int edNaive(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return edNaive(s1, s2, m - 1, n - 1);
        } else {
            return 1 + Math.min(
                    Math.min(edNaive(s1, s2, m - 1, n), edNaive(s1, s2, m, n - 1)),
                    edNaive(s1, s2, m - 1, n - 1));
        }
    }


    int edDp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1])
                            , dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

}

class Main {
    public static void main(String[] args) {
        EditDistanceProblem c = new EditDistanceProblem();
        String s1 = "cat";
        String s2 = "cut";
        System.out.println(c.edNaive(s1, s2, s1.length(), s2.length())); // 1


        /*
            c a t
          0 1 2 3
        c 1 0 1 2
        u 2 1 1 2
        t 3 2 2 1
        */
        System.out.println(c.edDp(s1, s2));
    }
}
