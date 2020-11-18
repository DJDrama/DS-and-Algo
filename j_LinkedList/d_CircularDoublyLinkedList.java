class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class CircularDoublyLinkedList {
    private static void printList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    private static Node insertAtHead(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
        return newNode;
    }

    private static Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            newNode.prev = newNode;
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = head;
        temp2.prev = temp1;
        temp1.prev = head;
        head.prev = temp2;

        printList(head);

        // insert
        head = insertAtHead(head, 5);
        printList(head);

        head = insertAtEnd(head, 123);
        printList(head);
    }
}


