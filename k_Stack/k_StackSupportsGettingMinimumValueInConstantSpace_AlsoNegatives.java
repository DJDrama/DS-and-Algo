import java.util.Stack;

// Design a stack with getmin() in O(1) space (Handling Negatives also)
public class StackSupportsGettingMinimumValueInConstantSpace_AlsoNegatives {
    private Stack<Integer> s;
    private int min;

    StackSupportsGettingMinimumValueInConstantSpace_AlsoNegatives() {
        s = new Stack<>();
    }

    void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
            min = x;
        } else if (x <= min) {
            s.push(2 * x - min);
            min = x;
        } else {
            s.push(x);
        }
    }

    int pop() {
        if (s.isEmpty()) return -1;
        int top = s.pop();
        if (top <= 0) {
            int res = min;
            min = 2 * min - top;
            return res;
        } else {
            return top;
        }
    }

    int peek() {
        int top = s.peek();
        if (top <= min)
            return min;
        else
            return top;
    }

    int getMin() {
        return min;
    }

}


class Main {
    public static void main(String[] args) {
        StackSupportsGettingMinimumValueInConstantSpace_AlsoNegatives s = new StackSupportsGettingMinimumValueInConstantSpace_AlsoNegatives();
        s.push(4);
        s.push(5);
        s.push(-8);
        s.push(1);
        s.push(-10);
        s.push(12);
        s.push(14);
        s.pop();

        System.out.println("peek : " + s.peek()); // 12
        System.out.println("min : " + s.getMin()); // -10

    }
}