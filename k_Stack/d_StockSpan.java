import java.util.Stack;

public class StockSpan {
    // Stock span (left small counts including self)
    // {13, 15, 12, 14, 16, 8, 6, 4, 10, 30}
    //   1,  2,  1,  2,  5, 1, 1, 1,  4, 10
    // {10, 20, 30, 40}
    //   1,  2,  3,  4
    // {40, 30, 20, 10}
    //   1,  1,  1,  1

    // Theta(n) time complexity
    // O(n) space complexity
    void printStockSpan(int[] arr) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        System.out.print(1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            System.out.print(span + " ");
            stack.push(i);
        }
    }

}

class Test {
    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};

        // 0-1 {0}
        // 15>=13 --> pop --> {}
        // span = 2
        // push(1) {1}
        // span = 2-1 = 1
        // push(2) {1, 2}
        // i=3
        // 14>=12 --> pop --> {15}
        // span = 3-1 = 2
        // push(3) {1, 3}
        // i=4
        // 16>=14, 16>=15 --> pop, pop
        // empty -->span = 4+1
        // push(4) {4}
        // i=5 --> 5-4=1
        // push(5) {4, 5}
        // i=6 --> 6-5=1
        // push(6) {4, 5, 6}
        // i=7 --> 7-6=1
        // push(7) {4, 5, 6, 7}
        // i=8 --> pop ,pop, pop --> {4}
        // 8-4 = 4
        // push(8) {4, 8}
        // i=9 --> pop, pop --> {}
        // 9+1=10
        stockSpan.printStockSpan(arr);
    }
}
