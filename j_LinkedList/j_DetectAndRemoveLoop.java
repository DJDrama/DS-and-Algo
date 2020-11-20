class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Detect and Remove Loop in a linked list
// 10->15->5->20->15->5->20->15.... --> 10->15->5->20
// 10 --> 10
// 10->15->20 --> 10->15->20
public class DetectAndRemoveLoop {
    // O(n) time complexity
    // O(1) space complexity
    static Node removeLoop(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (slow != fast) // In case of there is no loop
            return head;

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next; // Loop

        head = removeLoop(head);
        printList(head);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
