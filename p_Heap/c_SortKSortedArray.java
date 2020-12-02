import java.util.PriorityQueue;

public class SortKSortedArray {
    // Sort K-Sorted Array (i-k to i+k)
    // {9, 8, 7, 18, 19, 17}, k=2 --> {7, 8, 9, 17, 18, 19}
    // {10, 9, 7, 8, 4, 70, 50, 60}, k=4 --> {4, 7, 8, 9, 10, 50, 60, 70}

    // O(nlogk) time complexity
    // O(k) space complexity
    // if k is large then k=n
    void sortK(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i <= k; i++)
            q.offer(arr[i]);

        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = q.poll();
            q.offer(arr[i]);
        }
        while (!q.isEmpty())
            arr[index++] = q.poll();
    }
}

class Main {
    public static void main(String[] args) {
        SortKSortedArray s = new SortKSortedArray();
        int k = 3;
        int[] arr = {2, 6, 3, 12, 56, 8};
        s.sortK(arr, k);

        for (int num : arr)
            System.out.print(num + " ");
    }
}