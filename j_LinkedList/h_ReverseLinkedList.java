class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Test {
    // Reverse a LinkedList
    // 10->20->30->40  --> 40->30->20->10
    // 10 --> 10
    // null --> null
    static Node reverseLinkedListIterative(Node head) {
        if (head == null) return null;
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node reverseLinkedListRecursive1(Node head) {
        if (head == null || head.next == null) return head;
        Node restHead = reverseLinkedListRecursive1(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.next = null;
        return restHead;
    }

    static Node reverseLinkedListRecursive2(Node curr, Node prev) {
        if (curr == null) return prev;
        Node next = curr.next;
        curr.next = prev;
        return reverseLinkedListRecursive2(next, curr);
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

        head = reverseLinkedListIterative(head); // 30->15->20->5->10
        printList(head);

        head = reverseLinkedListRecursive1(head); // 10->5->20->15->30
        printList(head);

        head = reverseLinkedListRecursive2(head, null); // 30->15->20->5->10
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