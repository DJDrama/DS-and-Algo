public class RadixSort {
    // uses counting sort as a subroutine
    // 319, 212, 6, 8, 100, 50
    // --> 100, 050, 212, 006, 008, 319 //stable sort according to the last digit
    // --> 100, 006, 008, 212, 319, 050 //stable sort according to the middle digit
    // --> 006, 008, 050, 100, 212, 319 //stable sort according to the most significant digit
    // O(n) (theta(d*(n+b)) where b=10 below, theta(n+b) extra space
    void radixSort(int[] arr) {
        int max = arr[0];
        // finding max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, arr.length, exp);
    }

    private void countingSort(int[] arr, int n, int exp) {
        int[] count = new int[10];
        int[] output = new int[n];
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {319, 212, 6, 8, 100, 50};
        RadixSort r = new RadixSort();
        r.radixSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
