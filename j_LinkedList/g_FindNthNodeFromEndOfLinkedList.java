class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Test {
    // find nth node from end of linked list
    // 10->20->30->40->50, n=2 --> 40
    // 10->20->30, n=3 --> 10
    // 10->20, n=3 --> ""
    // 10->20->30 , n=1 //30
    private static void printNthMethod1(Node head, int n) {
        if (head == null)
            return;
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < count - n; i++)
            curr = curr.next;

        System.out.println(curr.data);

    }

    // Using Two Pointers
    private static void printNthMethod2(Node head, int n) {
        if (head == null) return;
        if (n == 1)
            System.out.println(head.data);
        Node start = head;
        Node ahead = head;
        for (int i = 0; i < n; i++)
            ahead = ahead.next;
        while (ahead != null) {
            ahead = ahead.next;
            start = start.next;
        }
        System.out.println(start.data);
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

        printNthMethod1(head, 2); // 15

        printNthMethod2(head, 3); // 20

    }


}