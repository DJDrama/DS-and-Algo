import java.util.Stack;

// Design a stack that supports getmin()
// push(20), push(10), getmin(), push(5), getmin(), pop(), getmin(), pop(), getmin()
// 10 5 10 20

// push(5), push(4), push(3), getmin(), pop(), getmin(), push(2), getmin()
// 3 4 2
public class StackSupportsGettingMinimumValue {
    Stack<Integer> masterStack, assistantStack;

    StackSupportsGettingMinimumValue() {
        masterStack = new Stack<>();
        assistantStack = new Stack<>();
    }

    void push(int x) {
        if (masterStack.isEmpty()) {
            masterStack.push(x);
            assistantStack.push(x);
            return;
        }
        masterStack.push(x);
        if (masterStack.peek() <= assistantStack.peek())
            assistantStack.push(x);
    }

    void pop() {
        if (masterStack.peek() == assistantStack.peek())
            assistantStack.pop();
        masterStack.pop();
    }

    int top() {
        return masterStack.peek();
    }

    int getMin() {
        return assistantStack.peek();
    }
}


class Main {
    public static void main(String[] args) {
        StackSupportsGettingMinimumValue s = new StackSupportsGettingMinimumValue();
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(2);
        s.push(1);
        s.push(11);
        s.push(13);
        s.pop();
        System.out.println("Min: " + s.getMin()); // 1
        s.pop();
        s.pop();
        System.out.println("Min: " + s.getMin()); // 2


    }
}