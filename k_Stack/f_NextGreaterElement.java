import java.util.Stack;

public class NextGreaterElement {
    // next greater element
    // {5, 15, 10, 8, 6, 12, 9, 18}
    // 15 18 12 12 12 18 18 -1
    // {10, 15, 20, 25}
    // 15 20 25 -1
    // {25, 20, 15, 10}
    // -1 -1 -1 -1

    // Theta(n) time complexity
    // O(n) space complexity
    void printNextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        stack.push(arr[arr.length - 1]);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int res = stack.isEmpty() ? -1 : stack.peek();
            sb.insert(0, res + " ");
            stack.push(arr[i]);
        }
        System.out.println(sb.toString());
    }
}

class Test {
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] arr = {5, 15, 10, 8, 6, 12, 9, 18};
        nge.printNextGreaterElement(arr);
    }
}
