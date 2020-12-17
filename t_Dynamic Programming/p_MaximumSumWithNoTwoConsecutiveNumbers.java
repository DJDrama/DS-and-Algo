public class MaximumSumWithNoTwoConsecutiveNumbers {
    // Maximum Sum With No Two Consecutive
    // {1, 10, 2} --> 10
    // {8, 7, 6, 10} --> 18
    // {10, 5, 15, 20, 2, 30} --> 60
    // {10, 5, 15, 20} --> 30

    // O(2^n) time complexity
    int maxSumRec(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        else if (n == 2)
            return Math.max(arr[0], arr[1]);
        else
            return Math.max(
                    maxSumRec(arr, n - 1),
                    maxSumRec(arr, n - 2) + arr[n - 1]
            );
    }

    int maxSumDp(int[] arr, int n) {
        if (n == 0)
            return arr[0];

        int prevPrev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;
        for (int i = 3; i <= n; i++) {
            res = Math.max(prev, prevPrev + arr[i - 1]);
            prevPrev = prev;
            prev = res;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumSumWithNoTwoConsecutiveNumbers m = new MaximumSumWithNoTwoConsecutiveNumbers();

        int[] arr = {10, 5, 15, 20, 2, 30};
        System.out.println(m.maxSumRec(arr, arr.length)); // 60
        System.out.println(m.maxSumDp(arr, arr.length)); // 60
    }
}