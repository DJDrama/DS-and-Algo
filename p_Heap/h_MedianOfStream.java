import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    // Median of a stream
    // {25, 7, 10, 15, 20} --> 25 16 10 12.5 15
    // 25 --> 25
    // 7 25 --> 16
    // 7 10 25 --> 10
    // 7 10 15 25 --> 12.5
    // 7 10 15 20 25 --> 15
    void printMedians(int[] arr) {
        PriorityQueue<Integer> g = new PriorityQueue<>();
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());

        s.offer(arr[0]);
        System.out.print(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            if (s.size() > g.size()) {
                if (s.peek() > x) {
                    g.offer(s.poll());
                    s.offer(x);
                } else {
                    g.offer(x);
                }
                System.out.print(((double) (s.peek() + g.peek()) / 2) + " ");
            }else{
                if(x<=s.peek()){
                    s.offer(x);
                }else{
                    g.offer(x);
                    s.offer(g.poll());
                }
                System.out.print(s.peek()+ " ");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MedianOfStream m = new MedianOfStream();
        int[] arr = {25, 7, 10, 15, 20};
        m.printMedians(arr);

    }
}