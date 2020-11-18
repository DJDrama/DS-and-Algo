class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node insertBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        return newNode;
    }

    private static Node insertEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }

    private static Node deleteLast(Node head) {
        if (head == null || head.next == null) return null;
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node t = new Node(20);
        Node t2 = new Node(30);
        head.next = t;
        t.prev = head;
        t.next = t2;
        t2.prev = t;

        printList(head);

        // Insert at Beginning
        head = insertBeginning(head, 5); // 5 10 20 30
        printList(head);

        // Insert at End
        head = insertEnd(head, 40); // 5 10 20 30 40
        printList(head);

        // Delete Head
        head = deleteHead(head); // 10 20 30 40
        printList(head);

        // Delete Last
        head = deleteLast(head); // 10 20 30
        printList(head);

    }
}


