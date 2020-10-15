public class CountDigits {

    // Iterative
    int countDigitsIterative(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    // Recursive
    int countDigitsRecursive(int n) {
        if (n == 0) return 0;
        return 1 + countDigitsRecursive(n / 10);
    }

    // Efficient
    int countDigitsLog(int n){
        return (int) Math.floor(Math.log10(n)+1);
    }
}

class Main {
    public static void main(String[] args) {
        CountDigits c = new CountDigits();

        int n = 1234;
        //4
        System.out.println("Digits : " + c.countDigitsIterative(n));
        //4
        System.out.println("Digits : " + c.countDigitsRecursive(n));
        //4
        System.out.println("Digits : " + c.countDigitsLog(n));
    }
}
