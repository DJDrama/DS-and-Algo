public class OddOccurrence {
    int findOnlyOneOddOccurringNumber(int[] arr) {
        int res = 0;
        for (int j : arr)
            res ^= j;
        return res;
    }

    void findTwoOddOccurringNumbers(int[] arr) {
        int xor = 0;
        int res1 = 0;
        int res2 = 0;

        for (int k : arr)
            xor ^= k;

        int sn = xor & -xor;
        for (int j : arr) {
            if ((j & sn) != 0)
                res1 ^= j;
            else
                res2 ^= j;
        }
        System.out.println(res1 + " " + res2);
    }
}

class Main {
    public static void main(String[] args) {
        OddOccurrence oddOccurrence = new OddOccurrence();

        // 4 occurs 4 times
        // 3 occurs 3 times
        // 5 occurs 2 times
        // 6 occurs 2 times
        // 1 occurs 2 times
        // so the answer should be 3 (occurs 3 times which is an odd number)
        int arr[] = {4, 3, 4, 4, 4, 5, 5, 6, 6, 1, 1, 3, 3};
        int value = oddOccurrence.findOnlyOneOddOccurringNumber(arr);
        // XOR Operation
        // 0^0=0, 0^1=1, 1^0=1, 1^1=0
        // 0^4 = 4,
        // example 1000 ^ 0000 = 1000
        // 4^3 --> 0100 ^ 0011 = 0111 which is 7
        System.out.println(value);  // 3

        // 3: 2, 4: 4, 5: 1, 6: 1, 7: 2
        // answer should be 5 and 6 which appear only 1 time
        arr = new int[]{3, 4, 3, 4, 5, 4, 4, 6, 7, 7};
        oddOccurrence.findTwoOddOccurringNumbers(arr); // 5 6

    }
}
