public class PrefixSumArray {
    // O(n) time complexity, O(1) space complexity
    int getRangeSumNaive(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            res += arr[i];
        }
        return res;
    }

    // O(1) time complexity, O(n) space complexity
    int getRangeSumEfficient(int[] arr, int start, int end) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + arr[i];
        }
        return prefixSum[end] - prefixSum[start - 1];
    }
}

class Main {
    public static void main(String[] args) {
        // Prefix Sum
        // Given a fixed array and multiple queries of following types on the array,
        // how to efficiently program their queries.
        // {2, 8, 3, 9, 6, 5, 4}
        // queries
        // getSum(0, 2), getSum(1, 3), getSum(2, 6)
        // 13, 20, 27
        PrefixSumArray ps = new PrefixSumArray();

        int[] arr = {2, 8, 3, 9, 6, 5, 4};

        /** Naive **/
        // getSum(1, 3), getSum(2, 6)
        System.out.println(ps.getRangeSumNaive(arr, 1, 3)); // 20
        System.out.println(ps.getRangeSumNaive(arr, 2, 6)); // 27

        System.out.println("------------------");

        /** Efficient **/
        System.out.println(ps.getRangeSumEfficient(arr, 1, 3)); // 20
        System.out.println(ps.getRangeSumEfficient(arr, 2, 6)); // 27

    }
}
