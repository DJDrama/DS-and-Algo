class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private static Node insertBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node insertEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = newNode;
        return head;
    }

    private static Node deleteHead(Node head) {
        if (head == null) return null;
        return head.next;
    }

    private static Node deleteLast(Node head) {
        if (head == null || head.next == null) return null;
        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    private static int search(Node head, int data) {
        if (head == null) return -1;
        Node curr = head;
        int position = 1;
        while (curr != null) {
            if (curr.data == data)
                return position;
            position++;
            curr = curr.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node head = null;

        // Insert Beginning
        head = insertBeginning(head, 30);
        head = insertBeginning(head, 20);
        head = insertBeginning(head, 10);
        head = insertBeginning(head, 5);
        printList(head); // 5 10 20 30

        // Insert End
        head = insertEnd(head, 40);
        printList(head); // 5 10 20 30 40

        // Delete Head
        head = deleteHead(head);
        printList(head); // 10 20 30 40

        // Delete Last
        head = deleteLast(head);
        printList(head); // 10 20 30

        // Search Index
        int index = search(head, 20);
        System.out.println(index);

    }
}


