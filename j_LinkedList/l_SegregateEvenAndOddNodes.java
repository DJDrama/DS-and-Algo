class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

//    segregate even and odd nodes of a linked list
//    (even first and then odd and relevant order)
//    17->15->8->12->10->5->4 ----> 8->12->10->4->17->15->5
//    8->12->10 ----> 8->12->10
//    1->3->5 ----> 1->3->5

public class SegregateEvenAndOddNodes {
    // O(n) time complexity
    // O(1) space complexity
    private static Node segregate(Node head) {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;

        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) { //even
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        if (evenStart == null || oddStart == null)
            return head;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4); //17->15->8->12->10->5->4
        printList(head);

        head = segregate(head);
        printList(head);

        head = new Node(17);
        head.next = new Node(10);
        head = segregate(head);
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
