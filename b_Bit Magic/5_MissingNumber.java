public class MissingNumber {
    int findMissingNumber(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length+1; i++) {
            res ^= i;
        }
        for (int j : arr) {
            res ^= j;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        int[] arr = {1, 4, 5, 3};
        int mn = missingNumber.findMissingNumber(arr);

        // 1) First xor from 1 to array's size + 1
        // res = 1^2^3^4^5 = 1

        // 2) Now xor of the array elements with the frist step's xor value
        // res = 1^1^4^5^3 = 2
        System.out.println(mn);
    }
}
