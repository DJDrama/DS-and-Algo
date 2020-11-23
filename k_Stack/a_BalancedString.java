import java.util.Stack;

public class BalancedString {
    // Check for balanced paranthesis in a string
    // given a string of parenthesis({,}, (,), [, ]),
    // we need to check if the string is balanced or not
    // "([])" --> yes
    // "((())" --> no
    // "[{]}" --> no
    // "{}[()]" --> yes

    // O(n) time complexity, O(n) space complexity
    boolean isBalanced(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char peek = stack.peek();
                if (c == ')' && peek != '('
                        || c == '}' && peek != '{'
                        || c == ']' && peek != '[')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

class Test {
    public static void main(String[] args) {
        BalancedString b = new BalancedString();
        String input = "([])";
        System.out.println(b.isBalanced(input)); // true

        input = "((())";
        System.out.println(b.isBalanced(input)); // false

        input = "[{]}";
        System.out.println(b.isBalanced(input)); // false

        input = "{}[()]";
        System.out.println(b.isBalanced(input)); // true
    }
}
