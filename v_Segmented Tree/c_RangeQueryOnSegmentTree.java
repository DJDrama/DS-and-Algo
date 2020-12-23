public class RangeQueryOnSegmentTree {
    // ex) {10, 20, 30, 40}
    //            100
    //           /   \
    //          30    70
    //         /  \   / \
    //        10  20 30  40
    //       / \ / \ /\  /\
    //     nullnullnullnullnull

    int constructSegmentTree(int ss, int se, int si, int[] arr, int[] tree) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }
        int mid = (ss + se) / 2;
        tree[si] = constructSegmentTree(ss, mid, 2 * si + 1, arr, tree)
                + constructSegmentTree(mid + 1, se, 2 * si + 2, arr, tree);
        return tree[si];
    }

    // Range Query on Segment Tree
    // O(logn) time complexity
    int getSumRec(int qs, int qe, int ss, int se, int si, int[] tree) {
        if (ss < qs || ss > qe) //when outside range
            return 0;
        if (qs <= ss && qe >= se) // when inside range
            return tree[si];

        int mid = (ss + se) / 2;
        return getSumRec(qs, qe, ss, mid, 2 * si + 1, tree)
                + getSumRec(qs, qe, mid + 1, se, 2 * si + 2, tree);
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int n = 4;
        // Size = 2*(2^ceil(log2N))-1 (if 4 elements, then 2*2^ceil(log2N)-1 =16-1=15
        int[] tree = new int[15];

        RangeQueryOnSegmentTree r = new RangeQueryOnSegmentTree();
        r.constructSegmentTree(0, n - 1, 0, arr, tree);

        // range(0, 2) sum
        System.out.println(r.getSumRec(0, 2, 0, n - 1, 0, tree)); // 60

    }
}