class ListNode {
    int key;
    ListNode next;

    ListNode(int key) {
        this.key = key;
        this.next = null;
    }
}

public class QueueUsingLinkedList {
    private ListNode front, rear;

    QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    void enqueue(int item) {
        ListNode temp = new ListNode(item);
        if (rear == null) {
            front = rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    int dequeue() {
        if (this.front == null)
            return Integer.MIN_VALUE;
        int res = this.front.key;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;

        return res;
    }
}

class Main {
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        int deq1 = queue.dequeue(); //1
        deq1 = queue.dequeue(); //2
        deq1 = queue.dequeue(); //3
        System.out.println(deq1); // 3


    }
}
