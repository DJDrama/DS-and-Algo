class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Palindrome Linked List
// r->a->d->a->r //yes
// t->f->t // yes
// g->e->e->k // no
public class PalindromeLinkedList {
    private static boolean isPalindrome(Node head) {
        if (head == null) return true;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node reversed = reverseList(slow.next);
        Node curr = head;
        while (reversed != null) {
            if (curr.data != reversed.data)
                return false;
            curr = curr.next;
            reversed = reversed.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node curr = head;
        Node next, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('a');
        if (isPalindrome(head))
            System.out.print("Yes");
        else
            System.out.print("No");
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
