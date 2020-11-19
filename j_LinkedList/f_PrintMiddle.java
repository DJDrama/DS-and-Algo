class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Test {
    // 10->5->20->15->30  --> 20
    // 10->5->20->15->30->45 --> 15
    static void printMiddleOfSingleLinkedList(Node head) {
        Node one = head;
        Node two = head;
        if (head == null)
            return;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        System.out.println(one.data);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(5);
        Node temp2 = new Node(20);
        Node temp3 = new Node(15);
        Node temp4 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;

        printMiddleOfSingleLinkedList(head); //20

        head = addNodeAtEnd(head, 45);
        printMiddleOfSingleLinkedList(head); // 15
    }

    static Node addNodeAtEnd(Node head, int data) {
        Node node = new Node(data);
        if (head == null)
            return node;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return head;
    }
}