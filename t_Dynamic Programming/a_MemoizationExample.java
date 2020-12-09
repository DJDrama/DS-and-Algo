import java.util.Arrays;

public class MemoizationExample {
    /** Memoization: Top Down **/
    int fibonacciNaive(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacciNaive(n - 1)
                + fibonacciNaive(n - 2);
    }

    int fibonacciMemo(int n, int[] memo) {
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1)
                return n;
            else
                res = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
            memo[n] = res;
        }
        return memo[n];
    }
}

class Main {
    public static void main(String[] args) {
        int n = 10;
        MemoizationExample m = new MemoizationExample();
        System.out.println(m.fibonacciNaive(n)); // 55

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(m.fibonacciMemo(n, memo)); //55

    }
}
