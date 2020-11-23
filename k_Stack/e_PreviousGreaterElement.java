import java.util.Stack;

public class PreviousGreaterElement {
    // Previous Greater Element
    // {15, 10, 18, 12, 4, 6, 2, 8}
    //  -1, 15, -1, 18, 12, 12, 6, 12
    // {8, 10, 12}
    //  -1 -1 -1
    // {12, 10, 8}
    //  -1, 12,10

    // Theta(n) time complexity
    // O(n) space complexity
    void printGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack();
        stack.push(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int res = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(res + " ");
            stack.push(arr[i]);
        }
    }

}

class Test {
    public static void main(String[] args) {
        PreviousGreaterElement pge = new PreviousGreaterElement();
        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        pge.printGreaterElement(arr);
    }
}
