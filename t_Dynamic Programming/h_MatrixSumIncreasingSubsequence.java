public class MatrixSumIncreasingSubsequence {
    int msis(int[] arr) {
        int n = arr.length;
        int[] msis = new int[n];
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    msis[i] = Math.max(msis[i], arr[i] + msis[j]);
                }
            }
        }
        int res = msis[0];
        for (int a : msis)
            res = Math.max(a, res);
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        MatrixSumIncreasingSubsequence m = new MatrixSumIncreasingSubsequence();
        int[] arr = {5, 10, 20};
        int sum = m.msis(arr);

        // msis = {0, 0, 0}
        // i=0, msis = {5, 0, 0}
        //      j=0
        // i=1, msis = {5, 10, 0}
        //      j=0
        //      arr[0] < arr[1]? yes
        //          msis[1] = max(10, 10+5) = 15
        //          msis = {5, 15, 0}
        // i=2, msis = {5, 15, 20}
        //      j=0
        //      arr[0] < arr[2]? yes
        //          msis[2] = max(20, 5+5)=20
        //          msis = {5, 15, 20}
        //      j=1
        //      arr[1] < arr[2]? yes
        //          msis[2] = max(20, 20+15)=35
        //          msis = {5, 15, 35}
        //
        // max = 35, return 35
        System.out.println(sum); // 35
    }
}
