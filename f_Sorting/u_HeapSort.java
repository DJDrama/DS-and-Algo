// O(nlogn) time complexity
// O(n) space complexity
public class HeapSort {
    void buildHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    void sort(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n);
    }

    void heapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }

    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Before Sort");
        printArray(arr);

        HeapSort h = new HeapSort();
        h.sort(arr);

        System.out.println("After Sort");
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }
}