public class InsertionSort {
    /** Stable Sort **/
    // Best : O(n) time complexity when input size is small and already sorted
    // Worst: O(n^2) time complexity
    // O(1) space complexity
    void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

class Main {
    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        int[] arr = {50, 20, 40, 60, 10, 30};
        i.insertionSort(arr);

        System.out.println("AFTER SORT");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
