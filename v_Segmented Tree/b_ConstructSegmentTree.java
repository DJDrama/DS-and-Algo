public class ConstructSegmentTree {
    // ex) {10, 20, 30, 40, 50, 60}
    //            210
    //           /   \
    //          60   150
    //         /  \   / \
    //        30  30 90  60
    //       /  \    / \
    //      10  20  40 50


    int constructSegmentTree(int[] arr, int[] tree, int s, int e, int i) {
        if (s == e) {
            tree[i] = arr[s];
            return arr[s];
        }
        int mid = (s + e) / 2;
        tree[i] = constructSegmentTree(arr, tree, s, mid, 2 * i + 1)
                + constructSegmentTree(arr, tree, mid + 1, e, 2 * i + 2);
        return tree[i];
    }

}

class Main {
    public static void main(String[] args) {
        ConstructSegmentTree c = new ConstructSegmentTree();
        int[] arr = {10, 20, 30, 40, 50, 60};
        // Size = 2*(2^ceil(log2N))-1 (if 6 elements, then 2*2^ceil(log2N)-1 =2*8-1=15
        int[] tree = new int[15];
        int res = c.constructSegmentTree(arr, tree, 0, arr.length - 1, 0);
        System.out.println(res); // root value = 210


    }
}
