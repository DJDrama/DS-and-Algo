public class PowerOfTwo {

    // Naive Solution
    boolean powerOfTwoNaive(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }

    // Efficient
    boolean powerOfTwoEfficient(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }
}

class Main {
    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        int n;

        /** Naive **/
        // 12%2 == 0, 12/2 = 6
        // 6%2 == 0, 6/2 = 3
        // 3%2 != 0 return false
        n = 12;
        System.out.println(powerOfTwo.powerOfTwoNaive(n)); //False

        // 16%2==0, 16/2=8
        // 8%2==0, 8/2=4
        // 4%2==0, 4/2=2
        // 2%2==0, 2/2=1
        // 1 --> Exit Loop, return true
        n = 16;
        System.out.println(powerOfTwo.powerOfTwoNaive(n)); //True

        /** Efficient **/
        n = 14;
        // 14 --> 1110, 13 --> 1101
        // 1110 & 1101 = 1100 which is not zero
        // return false
        System.out.println(powerOfTwo.powerOfTwoEfficient(n)); //False

        n = 64;
        // 64 --> 100000, 63 --> 011111
        // 100000 & 011111 = 000000 which is zero
        // return true
        System.out.println(powerOfTwo.powerOfTwoEfficient(n)); //True


    }
}
