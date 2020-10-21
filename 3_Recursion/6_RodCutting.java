public class RodCutting {
    // Time complexity : O(3^n)
    int maxCuts(int n, int a, int b, int c) {
        if(n==0) return 0;
        if(n<0) return -1;
        int res = Math.max(
                Math.max(maxCuts(n - a, a, b, c), maxCuts(n - b, a, b, c)),
                maxCuts(n - c, a, b, c));
        return res == -1 ? res : res + 1;
    }
}

/**
 * Given a rope of length n,
 * you need to find max number of pieces
 * you can make such that length of every piece is set {a, b, c}
 * for given those values a, b, and c
 * <p>
 * n=5, a=2, b=5, c=1 --> 5
 * n=23, a=12, b=9, c=11 --> 2
 * n=5, a=4, b=2, c=6 --> -1
 */
class Main {
    public static void main(String[] args) {
        RodCutting rc = new RodCutting();

        int n = 5, a = 2, b = 5, c = 1;
        System.out.println(rc.maxCuts(n, a, b, c));

        n=23;
        a=12;
        b=9;
        c=11;
        System.out.println(rc.maxCuts(n, a, b, c));

        n=5;
        a=4;
        b=2;
        c=6;
        System.out.println(rc.maxCuts(n, a, b, c));
    }
}
