class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Merge Two Sorted Linked Lists
// 10->20->30 & 5->25 --> 5->10->20->25->30
// 10->20 & null --> 10->20
// 10 & 40->50 --> 10->40->50
public class MergeTwoSortedLinkedLists {

    // O(m+n) time complexity (m = length of first list, n = length of second list)
    // O(1) space complexity
    private static Node mergeTwoSortedLists(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        Node res;
        Node tail;
        if (first.data > second.data) {
            res = second;
            tail = res;
            second = second.next;
        } else {
            res = first;
            tail = res;
            first = first.next;
        }
        while (first != null && second != null) {
            if (first.data > second.data) {
                tail.next = second;
                tail = second;
                second = second.next;
            } else {
                tail.next = first;
                tail = first;
                first = first.next;
            }
        }
        if(first==null)
            tail.next = second;
        else
            tail.next = first;
        return res;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        first.next = new Node(20);
        first.next.next = new Node(30);

        Node second = new Node(5);
        second.next = new Node(25);

        Node res = mergeTwoSortedLists(first, second);
        printList(res);
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
