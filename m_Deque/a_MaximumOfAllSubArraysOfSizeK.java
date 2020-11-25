import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubArraysOfSizeK {
    // maximums of all sub arrays of size k
    // We are given an array and a number k,
    // we need to find maximums of all subarrays of size k.
    // {10, 8, 5, 12, 15, 7, 6}, k=3 --> 10 12 15 15 15
    // {20, 5, 3, 8, 6, 15}, k=4 --> 20 8 15

    void printMaximums(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            if(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k; i<arr.length; i++){
            System.out.print(arr[dq.peek()] + " " );
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        System.out.print(arr[dq.peek()]);
    }
}

class Main {
    public static void main(String[] args) {
        MaximumOfAllSubArraysOfSizeK m = new MaximumOfAllSubArraysOfSizeK();
        int[] arr = {10, 8, 5, 12, 15, 7, 6};
        int n = 3;
        // sliding window technique
        // first k for loop
        // {0} --> {0, 1} --> {0, 1, 2}
        // second for loop
        // i=3 --> print arr[0] = 10 --> i-k=0 --> removeFirst --> {1, 2}
        // 12>=5 && 12>=8 --> {}
        // {3}
        // i=4 --> print arr[3] = 12 --> i-k=1 --> {3}
        // 12 <= 15 --> {}
        // {4}
        // i=5 --> print arr[4] = 15 --> i-k=2 --> {4}
        // {4, 5}
        // i=6 --> print arr[4] = 15 --> i-k=3 --> {4}
        // {4, 5, 6}
        // -- end loop --
        // last print arr[4] --> 15
        m.printMaximums(arr, n);  // 10 12 15 15 15
    }
}
