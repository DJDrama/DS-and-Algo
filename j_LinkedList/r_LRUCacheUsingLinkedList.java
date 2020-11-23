import java.util.HashMap;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCacheUsingLinkedList {
    private int capacity;
    private HashMap<Integer, Node> hashMap;
    private int count;
    private Node head, tail;

    LRUCacheUsingLinkedList(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    int get(int key) {
        if (hashMap.get(key) != null) {
            Node node = hashMap.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    void set(int key, int value) {
        if (hashMap.get(key) != null) {
            Node node = hashMap.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            hashMap.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                hashMap.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }

        }
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}

class Test {
    public static void main(String[] args) {
        int capacity = 2;
        LRUCacheUsingLinkedList cache = new LRUCacheUsingLinkedList(capacity);
        cache.set(1, 10); // 1
        cache.set(2, 20); // 2 1
        cache.set(3, 30); // 3 2

        System.out.println(cache.get(2)); // 20

        cache.set(4, 40); // 4 3

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // -1
        System.out.println(cache.get(4)); // 40

    }
}
