import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class KClosestElements {
    // K Closest Elements
    // {10, 15, 7, 3, 4} x=8, k=2 --> 7 10
    // {100, 80, 10, 5, 70}, x=2, k=3 --> 5 10 70
    void printClosestElements(int[] arr, int x, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((o1, o2) ->
                o2.value - o1.value
        );
        for (int i = 0; i < k; i++)
            q.offer(new Pair(arr[i], Math.abs(arr[i] - x)));
        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            Pair peeked = q.peek();
            if (peeked.value > diff) {
                q.poll();
                q.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            }
        }

        while (!q.isEmpty())
            System.out.print(q.poll().key + " ");
    }
}

class Main {
    public static void main(String[] args) {
        KClosestElements kc = new KClosestElements();
        int[] arr = {10, 30, 5, 40, 38, 80, 70};
        int x = 35;
        int k = 3;
        kc.printClosestElements(arr, x, k); // 40 30 38
    }
}