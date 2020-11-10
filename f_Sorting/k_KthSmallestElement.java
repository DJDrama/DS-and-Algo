import java.util.Arrays;

public class KthSmallestElement {
    // K-th Smallest Element (distinct elements)
    // {10, 5, 30, 12}, k=2 --> 10
    // {30, 20, 5, 10, 8} k=4 --> 20

    // O(nlogn) time complexity, O(1) space complexity
    int naiveSolution(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    // O(nlogn) but better and O(n) in some cases, but worse is O(n^2)
    int efficientSolution(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int p = lomutoPartition(arr, l, r);
            if (p == k - 1)
                return p;
            else if (p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    private int lomutoPartition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

}

class Main {
    public static void main(String[] args) {
        KthSmallestElement t = new KthSmallestElement();
        int[] arr = {10, 4, 5, 8, 11, 6, 26};
        int k = 5;
        System.out.println(t.naiveSolution(arr, k));

        arr = new int[]{10, 4, 5, 8, 11, 6, 26};
        System.out.println("index : "  + t.efficientSolution(arr, k));


    }
}
