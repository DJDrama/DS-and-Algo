class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Detect a loop in a linked list
// 10->15->12->20->15->12->20->15->12->20->.... --> yes
// null --> false
// Floyd's Cycle Detection
public class DetectLoop {
    // O(m + n(loop)) --> O(n) time complexity
    // O(1) space complexity
    static boolean isLooping(Node head) {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next; // Loop

        System.out.println(isLooping(head)); //true

        head.next.next.next.next = new Node(40); //No Loop
        System.out.println(isLooping(head));

        head = null; // head is null
        System.out.println(isLooping(head));
    }
}
