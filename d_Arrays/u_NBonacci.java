public class NBonacci {
    // O(n) time complexity, O(m) space complexity
    void printNBonacci(int n, int m) {
        int[] arr = new int[m];
        arr[n] = 1;
        arr[n - 1] = 1;

        for (int i = n + 1; i < m; i++) {
            arr[i] = 2 * arr[i - 1] - arr[i - n - 1];
        }
        for (int j : arr)
            System.out.print(j + " ");
    }
}

class Main {
    public static void main(String[] args) {
        NBonacci nBonacci = new NBonacci();
        // n-bonacci
        // present first m numbers O(n*m)
        // n=3, m=8 --> 0 0 1 1 2 4 7 13
        // n=4, m=10 --> 0 0 0 1 1 2 4 8 15 29
        int n = 3;
        int m = 8;
        nBonacci.printNBonacci(n, m);

        System.out.println("\n--------------------------------");

        n = 4;
        m = 10;
        nBonacci.printNBonacci(n, m);

    }
}
