import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    private int size;

    StackUsingQueue() {
        this.size = 0;
    }

    void push(int x) {
        this.size++;
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.peek());
            q1.poll();
        }

        // Exchanging q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;  // q2 will have nothing
    }

    int pop() {
        if (q1.isEmpty())
            return Integer.MIN_VALUE;
        int res = q1.poll();
        this.size--;
        return res;
    }

    int top() {
        if (q1.isEmpty())
            return Integer.MIN_VALUE;
        return q1.peek();
    }

    int size() {
        return this.size;
    }

}

class Main {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        System.out.println(stack.size()); // 1
        System.out.println(stack.top()); // 10

        stack.push(5);
        System.out.println(stack.size()); // 2
        System.out.println(stack.top()); // 5

        System.out.println(stack.pop()); // 5
        System.out.println(stack.size()); // 1

    }
}
