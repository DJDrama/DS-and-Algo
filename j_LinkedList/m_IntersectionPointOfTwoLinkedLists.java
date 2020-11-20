import java.util.HashSet;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Intersection Point of Two Linked Lists
// 5->8->7->10->12->15->null, 9->10->12->15->null
// intersection point : 10
public class IntersectionPointOfTwoLinkedLists {

    // Using HashSet
    // O(n) time complexity, O(n) space complexity
    private static int getIntersectionPointUsingHashSet(Node first, Node second) {
        HashSet<Integer> set = new HashSet<>();
        Node curr = first;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }
        curr = second;
        while (curr != null) {
            if (set.contains(curr.data))
                return curr.data;
            curr = curr.next;
        }
        return -1;
    }

    // Using count
    // O(n) time complexity, O(1) space complexity
    private static int getIntersectionPoint(Node first, Node second) {
        // get Counts
        int countFirst = 0, countSecond = 0;
        Node curr = first;
        while (curr != null) {
            countFirst++;
            curr = curr.next;
        }
        curr = second;
        while (curr != null) {
            countSecond++;
            curr = curr.next;
        }

        curr = first;
        Node curr2 = second;
        int diff = Math.abs(countFirst - countSecond);
        if (countFirst > countSecond) {
            for (int i = 0; i < diff; i++) {
                if (curr == null)
                    return -1;
                curr = curr.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                if (curr2 == null)
                    return -1;
                curr2 = curr2.next;
            }
        }
        while (curr != null && curr2 != null) {
            if (curr.data == curr2.data)
                return curr.data;
            curr = curr.next;
            curr2 = curr2.next;
        }
        return -1;
    }


    public static void main(String[] args) {
        Node first = new Node(5);
        first.next = new Node(8);
        first.next.next = new Node(7);
        first.next.next.next = new Node(10);
        first.next.next.next.next = new Node(12);
        first.next.next.next.next.next = new Node(15);

        Node second = new Node(9);
        second.next = new Node(10);
        second.next.next = new Node(12);
        second.next.next.next = new Node(15);

        int intersectionPoint = getIntersectionPointUsingHashSet(first, second);
        System.out.println(intersectionPoint);

        intersectionPoint = getIntersectionPoint(first, second);
        System.out.println(intersectionPoint);
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
