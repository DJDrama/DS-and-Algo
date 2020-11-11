import java.util.HashMap;

public class LongestSubArrayWithGivenSum {
    // {5, 8, -4, -4, 9, -2, -2}, sum=0 --> 3 {8, -4, -4}
    // {3, 1, 0, 1, 8, 2, 3, 6}, sum=5 --> 4 {3, 1, 0, 1}
    int maxLength(int[] arr, int sum) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(prefixSum == sum)
                res = i+1;
            if (!map.containsKey(prefixSum)) // Just Put the LeftMost Element
                map.put(prefixSum, i);
            if (map.containsKey(prefixSum - sum))
                res = Math.max(res, i - map.get(prefixSum - sum));
        }

        return res;
    }

}

class Main {
    public static void main(String[] args) {
        LongestSubArrayWithGivenSum l = new LongestSubArrayWithGivenSum();
        int[] arr = {5, 8, -4, -4, 9, -2, -2};
        int sum = 0;
        System.out.println(l.maxLength(arr, sum)); // 3

        arr = new int[]{3, 1, 0, 1, 8, 2, 3, 6};
        sum=5;
        System.out.println(l.maxLength(arr, sum)); // 4

    }
}
