import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    // K Largest Elements
    // {5, 15, 10, 20, 8} , k=2 --> 15 20
    // {8, 6, 4, 10, 9}, k=3 --> 8 9 10
    void printKLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            q.offer(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (q.peek() > arr[i]) continue;
            q.poll();
            q.offer(arr[i]);
        }

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
    }
}

class Main {
    public static void main(String[] args) {
        KLargestElements kl = new KLargestElements();
        int[] arr = {5, 15, 10, 20, 8};
        int k = 2;
        kl.printKLargestElements(arr, k);
    }
}