import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumberWithGivenDigits {

    // generate numbers with given digits
    // Given a number n, print first n number
    // (in increasing order) such that all these numbers have digits in set {5, 6}
    // n = 10
    // 5, 6, 55, 56, 65, 66, 555, 556, 565, 566
    // n = 4
    // 5, 6, 55, 56

    void printGeneratedNumbers(int n) {
        Queue<String> q = new LinkedList<>();
        q.offer("5");
        q.offer("6");

        for (int i = 0; i < n; i++) {
            String curr = q.poll();
            System.out.print(curr + " ");
            q.offer(curr + "5");
            q.offer(curr + "6");
        }
    }
}

class Main {
    public static void main(String[] args) {
        GenerateNumberWithGivenDigits g = new GenerateNumberWithGivenDigits();
        int n = 10;
        g.printGeneratedNumbers(n);
    }
}
