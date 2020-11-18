class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(5);
        head.next.next = new Node(20);
        head.next.next.next = new Node(15);
        head.next.next.next.next = head;
        printList(head);

        head = insertAtBeginning(head, 3);
        printList(head);

        head = insertAtEnd(head, 40);
        printList(head);

        head = deleteHead(head);
        printList(head);

        head = deleteKthElement(head, 3);
        printList(head);
    }

    private static void printList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    private static Node insertAtBeginning(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = head.next;
        head.next = newNode;

        int data = newNode.data;
        newNode.data = head.data;
        head.data = data;
        return head;
    }

    private static Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = head.next;
        head.next = newNode;

        int data = newNode.data;
        newNode.data = head.data;
        head.data = data;

        return newNode;
    }

    private static Node deleteHead(Node head) {
        if (head == null) return null;
        if (head.next == head) return null;
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    private static Node deleteKthElement(Node head, int index) {
        if (head == null) return null;
        if (index == 1)
            return deleteHead(head);
        Node curr = head;
        for (int i = 0; i < index - 2; i++)
            curr = curr.next;
        curr.next = curr.next.next;
        return head;

    }
}


