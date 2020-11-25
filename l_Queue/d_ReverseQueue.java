import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    // reversing a queue
    // {10, 5, 15, 20} --> {20, 15, 5, 10}
    void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int f = q.poll(); // head element
        reverse(q);
        q.offer(f);
    }

    void printQueue(Queue<Integer> q) {
        for (int i : q) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Main {
    public static void main(String[] args) {
        ReverseQueue q = new ReverseQueue();

        int[] arr = {10, 5, 15, 20};
        Queue<Integer> queue = new LinkedList<>();
        for (int num : arr)
            queue.offer(num);
        q.printQueue(queue);

        // Reverse
        q.reverse(queue);

        q.printQueue(queue);
    }
}
