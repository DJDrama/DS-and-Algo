public class EggDroppingPuzzle {
    // e-> no of eggs
    // f-> no of floors
    // e=1, f=10 --> 10
    // e=2, f=10 --> 4
    // n = egg, k = floor

    // get minimum number of trials needed in worst case with n eggs and k floors
    int eggDrop(int n, int k) {
        if (k == 1 || k == 0)
            return k;

        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        int res;
        int x;
        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));

            if (res < min)
                min = res;
        }
        return min + 1;
    }
}

class Main {
    public static void main(String[] args) {
        EggDroppingPuzzle e = new EggDroppingPuzzle();

        int n = 2;
        int k = 10;
        System.out.println(e.eggDrop(n, k));
    }
}