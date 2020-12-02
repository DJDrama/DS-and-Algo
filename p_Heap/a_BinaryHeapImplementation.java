/**
 * MinHeap
 **/
public class BinaryHeapImplementation {
    int[] arr;
    int size;
    int capacity;

    BinaryHeapImplementation(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void insert(int x) {
        if (size == capacity) return;
        size++;
        arr[size - 1] = x;
        // swap if parent is bigger than the current, and make i to parent
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void minHeapify(int i) {
        int lt = left(i);
        int rt = right(i);
        int smallest = i;
        if (lt < size && arr[lt] < arr[i])
            smallest = lt;
        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;
        if (smallest != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // continue if there is smaller item by recursion
            minHeapify(smallest);
        }
    }

    int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return arr[0];
        }
        // swap lowest to the largest
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;

        size--;
        // heapify with the largest, and remove the lowest
        minHeapify(0);

        return arr[size];
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            // swap if parent is larger
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            i = parent(i);
        }
    }

    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int capacity = 11;
        BinaryHeapImplementation b = new BinaryHeapImplementation(capacity);
        // size=1, arr[0]=3 {3}
        b.insert(3);
        // size=2, arr[1]=2
        // for: i=1, i!=0 && parent(1)=0, arr[0]=3, arr[0]=3 > arr[1]=2
        // swap(2 & 3), i=parent(1)=0 --> {2, 3}
        b.insert(2);
        // size=3, arr[2]=15
        // for: i=2, i!=0 && parent(2)=0, arr[0]=2, arr[2]=15 (pass)
        // {2, 3, 15}
        b.insert(15);
        // {2, 3, 15, 20}
        b.insert(20);

        // ExtractMin
        System.out.println(b.extractMin()); // 2

        b.decreaseKey(2, 1);
        // Delete
        b.deleteKey(0);
        System.out.println(b.extractMin()); // 3

    }
}