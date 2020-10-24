public class TrappingRainWater {
    //Trapping Rain Water
    //arr[] = {2, 0, 2} --> 2
    //arr[] = {3, 0, 1, 2, 5} --> 6
    //ar[] = {1, 2, 3} --> 0 , arr[] = {3, 2, 1} --> 0

    //O(n) space Complexity, O(n) time complexity
    int getWaterEfficient(int[] arr) {
        int res = 0;
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);

        // 1 ~ n-1 because left and right edge is the starting points
        for (int i = 1; i < n - 1; i++)
            res += Math.min(leftMax[i], rightMax[i]) - arr[i];
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] arr = new int[]{2, 0, 2};
        System.out.println(trw.getWaterEfficient(arr)); // 2

        arr = new int[]{3, 0, 1, 2, 5};
        System.out.println(trw.getWaterEfficient(arr)); // 6

        arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.getWaterEfficient(arr)); // 6
    }
}
