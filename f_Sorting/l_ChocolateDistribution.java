import java.util.Arrays;
public class ChocolateDistribution {
    // finding minimum diff in m elements
    // {7, 3, 2, 4, 9, 12, 56}, m=3 --> 2 {3, 2, 4} --> max=4 - min=2 = 2
    // {3, 4, 1, 9, 56, 7, 9, 12} m=5 --> 6 {3, 4, 7, 9, 9} --> 9 - 3 = 6
    // O(nlogn) time complexity, O(1) space complexity
    int minDiff(int[] arr, int m) {
        int n = arr.length;
        if (m > n)
            return -1;

        Arrays.sort(arr);
        int minDiff = arr[m - 1] - arr[0];
        for (int i = 0; i + (m - 1) < n; i++) {
            minDiff = Math.min(arr[i + m - 1] = arr[i], minDiff);
        }
        return minDiff;
    }

}

class Main {
    public static void main(String[] args) {
        ChocolateDistribution c = new ChocolateDistribution();
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;

        System.out.println(c.minDiff(arr, m)); // 2
    }
}
