public class CountSetBits {

    // naive
    int countSetBitsNaive(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                res++;
            n = n >> 1;
        }
        return res;
    }

    // Brian Kerninghan
    int countSetBitsBK(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        CountSetBits countSetBits = new CountSetBits();

        int n = 13; //1101 --> 3 set bits
        // 1101 & 1 --> 1
        // 110 & 1 --> 0
        // 11 & 1 --> 1
        // 1 & 1 --> 1
        // three 1s
        System.out.println(countSetBits.countSetBitsNaive(n)); // 3

        /** Brian KerningHan **/
        n = 13; //1101
        // 13 & 12 = 1101 & 1100 = 1100, res++
        // 1100 & 1011 = 1000, res++
        // 1000 & 0111 = 0000, res++
        // n becomes 0 exit loop, res = 3
        System.out.println(countSetBits.countSetBitsBK(n)); // 3

        n = 9; //1001
        // 9 & 8 --> 1001 & 1000 = 1000, res++;
        // 1000 & 0111 = 0000, res++;
        // n becomes 0 exit loop. res = 2
        System.out.println(countSetBits.countSetBitsBK(n)); // 2

    }
}
