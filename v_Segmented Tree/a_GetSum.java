public class GetSum {
    // {10, 20, 30, 40, 50}
    // getsum(0, 2), getsum(1, 3), update(1, 60),
    // getsum(0, 2), getsum(1, 3)
    // --> 60 90 100 130

    /**
     * Naive
     **/
    // O(n) time complexity
    int getSum(int[] arr, int qs, int qe) {
        int sum = 0;
        for (int i = qs; i <= qe; i++)
            sum += arr[i];
        return sum;
    }

    void update(int[] arr, int i, int value) {
        arr[i] = value;
    }

    /**
     * Prefix Sum
     **/

    // O(n) time complexity
    // O(n) space complexity
    void initialize(int[] prefixSum, int[] arr) {
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            prefixSum[i] += prefixSum[i - 1] + arr[i];
    }

    int getSumPrefixSum(int[] prefixSum, int qs, int qe) {
        if (qs == 0)
            return prefixSum[qe];
        return prefixSum[qe] - prefixSum[qs - 1];
    }

    void updatePrefixSum(int[] prefixSum, int[] arr, int i, int value) {
        int diff = value - arr[i];
        for (int j = i; j < arr.length; j++)
            prefixSum[j] += diff;
    }

}

class Main {
    public static void main(String[] args) {
        GetSum g = new GetSum();
        int[] arr = {10, 20, 30, 40, 50};
        System.out.print(g.getSum(arr, 0, 2) + " "); // 60
        System.out.print(g.getSum(arr, 1, 3) + " "); // 90
        g.update(arr, 1, 60);
        System.out.print(g.getSum(arr, 0, 2) + " "); // 100
        System.out.print(g.getSum(arr, 1, 3) + " "); // 130

        System.out.println("\n------------------------");


        // Prefix Sum
        arr = new int[]{10, 20, 30, 40, 50};
        int[] ps = new int[arr.length];
        g.initialize(ps, arr);
        System.out.print(g.getSumPrefixSum(ps, 0, 2) + " "); // 60
        System.out.print(g.getSumPrefixSum(ps, 1, 3) + " "); // 90
        g.updatePrefixSum(ps, arr, 1, 60);
        System.out.print(g.getSumPrefixSum(ps, 0, 2) + " "); // 100
        System.out.print(g.getSumPrefixSum(ps, 1, 3) + " "); // 130
    }
}
