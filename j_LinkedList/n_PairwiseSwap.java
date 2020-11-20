import java.util.HashSet;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Pairwise Swap Nodes of a linked list
// 1->2->3->4 -----> 2->1->4->3
// 1->2->3->4->5 -----> 2->1->4->3->5
public class PairwiseSwap {

    // O(n) time complexity
    // O(1) space complexity
    private static Node swap1(Node head) {
        Node curr = head;
        while(curr!=null && curr.next!=null){
            int temp = curr.next.data;
            curr.next.data = curr.data;
            curr.data = temp;

            curr = curr.next.next;
        }
        return head;
    }

    private static Node swap2(Node head){
        if(head == null || head.next==null)
            return head;
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;
        while(curr!=null && curr.next!=null){
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);
        first.next.next.next = new Node(4);
        first.next.next.next.next = new Node(5);
        printList(first);

        first = swap1(first);
        printList(first);

        first = swap2(first);
        printList(first);

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
