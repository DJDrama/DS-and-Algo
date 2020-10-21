public class Factorial {
    // 5! = 5*4*3*2*1
    int factorialNonTailRecursive(int n) {
        if (n < 2) return 1; //0!=1, 1!=1
        return factorialNonTailRecursive(n - 1) * n;
    }

    int factorialTailRecursive(int n, int k) {
        if (n < 2) return k;
        return factorialTailRecursive(n - 1, k * n);
    }
}

class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        // 4*3*2*1
        System.out.println(factorial.factorialNonTailRecursive(4));
        // 4, 1 --> 4
        // 3, 4 --> 12
        // 2, 12 --> 24
        // 1, 24 --> 24
        System.out.println(factorial.factorialTailRecursive(2, 1));
    }
}
