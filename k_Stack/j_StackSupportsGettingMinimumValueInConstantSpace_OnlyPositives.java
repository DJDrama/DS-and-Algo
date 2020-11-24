import java.util.Stack;

// Design a stack with getmin() in O(1) space (Assuming all values are positive)
public class StackSupportsGettingMinimumValueInConstantSpace_OnlyPositives {
    private Stack<Integer> s;
    private int min;

    StackSupportsGettingMinimumValueInConstantSpace_OnlyPositives() {
        s = new Stack<>();
    }

    void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
            min = x;
        } else if (x <= min) {
            s.push(x - min);
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
            min -= top;
            return res;
        } else {
            return top;
        }
    }

    int peek() {
        int top = s.peek();
        if (top <= 0)
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
        StackSupportsGettingMinimumValueInConstantSpace_OnlyPositives s = new StackSupportsGettingMinimumValueInConstantSpace_OnlyPositives();
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.println("peek : " + s.peek());
        System.out.println("min : " + s.getMin());

    }
}