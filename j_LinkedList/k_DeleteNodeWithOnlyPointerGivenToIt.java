class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Delete a node with only pointer given to it
//  10->20->30->40->25->null
// pointer or reference to node with value 30(not head) (never the end node)
// --> answer : 10->20->40->25->null
public class DeleteNodeWithOnlyPointerGivenToIt {
    // swap data with the next node
    // and connect to the next next node
    static void deleteNode(Node ptr) {
        ptr.data = ptr.next.data;
        ptr.next = ptr.next.next;
    }

    public static void main(String[] args) {
        /*Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(25);*/
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
