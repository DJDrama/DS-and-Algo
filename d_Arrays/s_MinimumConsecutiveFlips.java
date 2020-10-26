public class MinimumConsecutiveFlips {
    // Minimum Group Flips to Make same (minimum flip to make array same)
    // {1, 1, 0, 0, 0, 1} --> from 2 to 4
    // {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1} -> from 1 to 3, from 5 to 6
    // {1, 1, 1} --> none
    // {0, 1} --> 0 to 0, 1 to 1

    // O(n) time complexity, O(1) space complexity
    void printMinimumFlips(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else
                    System.out.println(i - 1);
            }
        }
        if (arr[arr.length - 1] != arr[0])
            System.out.println(arr.length - 1);
    }

}

class Main {
    public static void main(String[] args) {
        MinimumConsecutiveFlips m = new MinimumConsecutiveFlips();
        int[] arr = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1};
        m.printMinimumFlips(arr);

        System.out.println("--------");
        arr = new int[]{1, 1, 0, 0, 0, 1};
        // 1, 1, 0 ... --> 0 is different to 1
        // and 0 is different to arr[0] --> From 2 to
        // last 1 is different to previous 0
        // but 1 is same to arr[0]
        // so print 5-1 = 4 --> From 2 to 4
        m.printMinimumFlips(arr);

        System.out.println("--------");
        arr = new int[]{1, 1, 1}; // None
        m.printMinimumFlips(arr);

        System.out.println("--------");
        arr = new int[]{0, 1};
        // 1 is different to 0
        // 1 is different to arr[0] --> From 1 to
        // End Loop
        // arr[arr.length-1] which is 1 is different to arr[0] which is 0
        // print(arr.length - 1) --> From 1 to (2-1)1
        // From 1 to 1
        m.printMinimumFlips(arr);
    }
}
