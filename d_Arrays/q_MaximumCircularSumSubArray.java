public class MaximumCircularSumSubArray {
    //Maximum Circular Subarray Sum
    // {10, 5, -5} --> {10}, {5}, {-5}, {10, 5}, {5, -5}, {10, 5, -5} //Normal
    // -->(circular) --> {5, -5, 10}, {-5, 10}, {-5, 10, 5} //Circular
    //{5, -2, 3, 4} --> 12 (3 + 4 + 5)
    //{2, 3, -4} --> 5 (2+3)
    //{8, -4, 3, -5, 4} --> 12(4+8)
    //{-3, 4, 6, -2} --> 10(4+6)

    // O(n) time complexity, O(1) space complexity
    int getMaximumCircularSum(int[] arr) {
        int maxNormal = getMaximumSum(arr);
        // if {-2, -3, -1} --> maxNormal will be -1
        // if this condition is not set, then return value will be 0.
        // because below getMaximumSum(arr) will be 0 (-6 + 6 = 0)
        // so this if statement is needed.
        if(maxNormal < 0)
            return maxNormal;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }
        sum += getMaximumSum(arr);
        System.out.println(sum);
        return Math.max(sum, maxNormal);
    }

    int getMaximumSum(int[] arr) {
        int res = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumCircularSumSubArray m = new MaximumCircularSumSubArray();
        int[] arr = {-8, 4, -3, 5, -4};
        // 1) getMaximumSum --> 8
        // 2) getMaximumCircularSum
        // sum = 6
        // MaximumSum of {-8, 4, -3, 5, -4} 6
        // sum += 6 is 12
        // return max(8, 12) --> answer is 12
        System.out.println(m.getMaximumCircularSum(arr));

    }
}
