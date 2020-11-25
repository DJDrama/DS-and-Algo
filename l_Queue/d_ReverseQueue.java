import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    // reversing a queue
    // {10, 5, 15, 20} --> {20, 15, 5, 10}
    void reverseRecursive(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int f = q.poll(); // head element
        reverseRecursive(q);
        q.offer(f);
    }

    void reverseIterative(Queue<Integer> q) {
        Stack<Integer> stack = new Stack();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
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

        // Reverse Recursively
        System.out.println("-- Reverse --");
        q.reverseRecursive(queue);
        q.printQueue(queue);

        // Reverse Iteratively
        System.out.println("-- Reverse --");
        q.reverseIterative(queue);
        q.printQueue(queue);
    }
}
