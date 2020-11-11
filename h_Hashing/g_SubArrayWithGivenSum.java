import java.util.HashSet;

public class SubArrayWithGivenSum {
    // Sub array with given sum
    // {5, 8, 6, 13, 3, -1} // 22 --> yes {6, 13, 3}
    // O(n) time complexity, O(n) space complexity
    boolean hasSubArrayWithGivenSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet();
        int prefixSum = 0;
        for (int num : arr) {
            if (prefixSum == sum)
                return true;
            prefixSum += num;
            if (set.contains(prefixSum - sum))
                return true;
            set.add(prefixSum);
        }
        return false;
    }

}

class Main {
    public static void main(String[] args) {
        SubArrayWithGivenSum s = new SubArrayWithGivenSum();
        int[] a = new int[]{5, 8, 6, 13, 3, -1};
        int sum = 22;
        // Prefix Sum {5, 13, 19, 32, 35, 34}
        // prefixSum = 5, set : {5}
        // prefixSum = 13, set : {5, 13}
        // prefixSum = 19, set : {5, 13, 19}
        // prefixSum = 32, set : {5, 13, 19, 32}
        // prefixSum = 35, set contains (35 - 22 = 13} // so return true
        System.out.println(s.hasSubArrayWithGivenSum(a, sum));
    }
}
