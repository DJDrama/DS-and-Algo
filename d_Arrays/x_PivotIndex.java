public class PivotIndex {
    // O(n) time complexity, O(1) space complexity
    boolean hasPivotIndex(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;

        int left = 0;
        for (int i : arr) {
            if (left == sum - i)
                return true;
            left += i;
            sum -= i;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        // Given an array of integers, find it has an equilibrium point
        // {3, 4, 8, -9, 20, 6} --> Yes --> 6 20 6
        // {4, 2, -2} --> Yes --> 4 0 --> yes
        // {4, 2, 2} --> No
        PivotIndex eq = new PivotIndex();
        int[] arr = {3, 4, 8, -9, 20, 6};
        System.out.println(eq.hasPivotIndex(arr)); // True

        arr = new int[]{4, 2, -2};
        System.out.println(eq.hasPivotIndex(arr)); // True

        arr = new int[]{4, 2, 2};
        System.out.println(eq.hasPivotIndex(arr)); // False
    }
}
