public class MaximumSumConsecutiveK {

    // O(n) time complexity, O(1) space Complexity
    int maximumSumConsecutiveK(int[] arr, int k) {
        int firstKSum = 0;
        for (int i = 0; i < k; i++)
            firstKSum += arr[i];
        int max = firstKSum;
        for (int i = k; i < arr.length; i++) {
            firstKSum += arr[i] - arr[i - k];
            max = Math.max(firstKSum, max);
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumSumConsecutiveK s = new MaximumSumConsecutiveK();
        // 1, 8, 30, -5, 20, 7, k=3 --> 45 (30 -5 + 20)
        int[] arr = {1, 8, 30, -5, 20, 7};
        int k = 3;
        int maxSum = s.maximumSumConsecutiveK(arr, k);
        System.out.println("Max Sum : " + maxSum);
    }
}
