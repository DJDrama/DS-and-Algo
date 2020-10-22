public class KthBitSetOrNot {
    boolean isKthBitSet_LeftShift(int n, int k) {
        return (n & (1 << k - 1)) != 0;
    }
    boolean isKthBitSet_RightShift(int n, int k){
        return ((n >> k-1) & 1) !=0;
    }
}

class Main {
    public static void main(String[] args) {

        KthBitSetOrNot kthBitSetOrNot = new KthBitSetOrNot();

        /** Left Shift **/
        int n = 13;
        int k = 3;
        // 13 --> 1101
        // is 3rd bit (from right) is set(1) ?
        // left shift 1 to (k-1) then 1 << 2(3-1) will become 100
        // 1101 & 100 --> 0100, so 0100 is not zero // True
        System.out.println(kthBitSetOrNot.isKthBitSet_LeftShift(n, k)); // true

        k=2;
        // 1 << 1(2-1) will become 10
        // 1101 & 0010 will become 0000 which is zero
        // returning false
        System.out.println(kthBitSetOrNot.isKthBitSet_LeftShift(n, k)); // false

        /** Right Shift **/
        k=3;
        // 1101 >> 2(3-1) will become 0011
        // 0011 & 1 is not zero which means "is set"
        // returning true
        System.out.println(kthBitSetOrNot.isKthBitSet_RightShift(n, k)); // true
        k=2;
        // 1101 >> 1(2-1) will become 0110
        // 0110 & 1 is zero which means "not set"
        // returning false
        System.out.println(kthBitSetOrNot.isKthBitSet_RightShift(n, k)); // false

    }
}
