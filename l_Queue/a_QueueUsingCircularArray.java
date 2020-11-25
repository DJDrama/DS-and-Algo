public class QueueUsingCircularArray {
    private int front, rear, size;
    private int capacity;
    private int[] array;

    QueueUsingCircularArray(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
        this.rear = capacity - 1;
        this.array = new int[capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
    }

    int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return this.array[this.front];
    }

    int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return this.array[this.rear];
    }
}

class Main {
    public static void main(String[] args) {
        int capacity = 5;
        QueueUsingCircularArray queue = new QueueUsingCircularArray(capacity);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // "Queue is Full"

        int deq1 = queue.dequeue();
        System.out.println(deq1); // 1 (FIFO)

        System.out.println(queue.front() + " " + queue.rear()); // 2(front) 5(rear)

    }
}
