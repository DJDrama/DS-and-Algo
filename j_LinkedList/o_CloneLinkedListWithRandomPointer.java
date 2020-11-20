import java.util.HashSet;

class Node {
    Node next, random;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

// Clone a linked list with random pointer(or reference)
// 10->5->20->15->20 (5->25, 20->15->20->10, 10->20)
// copy but values are same and pointers are pointing same values
public class CloneLinkedListWithRandomPointer {
    // O(n) time complexity
    // O(1) space complexity
    static Node clone(Node head) {
        Node next, temp;
        for (Node curr = head; curr != null; ) {
            next = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = next;
            curr = next;
        }
        for (Node curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
        }
        Node original = head, copy = head.next;
        temp = copy;
        while (original != null && copy != null) {
            original.next = original.next != null ? original.next.next : original.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void main(String[] args) {


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
