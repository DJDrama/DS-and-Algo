public class LongestIncreasingSubsequence {
    // Longest Increasing Subsequence
    // {3, 4, 2, 8, 10} --> 4 ({3, 4, 8, 10})
    // {4, 10, 6, 5, 8, 11, 2, 20} --> 5 ({4, 5, 8, 11, 20})
    // {10, 20, 30} --> 3 ({10, 20, 30})
    // {30, 20, 10} --> 1 ({30} or {20} or {10})

    // {4, 10, 6, 5, 8, 11, 2, 20}
    //  0   1  2  3  4   5  6   7
    // lis[0]=1
    // lis[1]=2
    // lis[2]=2
    // lis[3]=2
    // lis[4]=3
    // lis[5]=4
    // lis[6]=1
    // lis[7]=5
    // O(n^2) time complexity, O(n) space complexity
    int lisDp(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int res = lis[0];
        for (int l : lis) {
            res = Math.max(l, res);
        }
        return res;
    }

    int lisNlogN(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        int len = 1;
        tail[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len++] = arr[i];
            } else {
                int c = ceilIdx(tail, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    int ceilIdx(int[] tail, int r, int key) {
        int l = 0;
        while (r > l) {
            int m = l + (r - l) / 2;
            if (tail[m] >= key)
                r = m;
            else
                l = m + 1;
        }
        return r;
    }

}

class Main {
    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] arr = {4, 10, 6, 5, 8, 11, 2, 20};
        System.out.println(l.lisDp(arr)); // 5
        System.out.println(l.lisNlogN(arr)); //5
    }
}
