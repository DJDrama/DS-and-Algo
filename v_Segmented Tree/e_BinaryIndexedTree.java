public class BinaryIndexedTree {
    private static final int MAX = 1000;
    private static final int[] binaryIndexedTree = new int[MAX];

    void constructBinaryIndexedTree(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            updateBinaryIndexedTree(n, i, arr[i]);
    }

    private void updateBinaryIndexedTree(int n, int index, int val) {
        index += 1;
        while (index <= n) {
            binaryIndexedTree[index] += val;
            index += index & (-index); // Bit Wise Operation
        }
    }

    int getSum(int index) {
        int sum = 0;
        index += 1;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index -= index & (-index);
        }
        return sum;
    }

}

class Main {
    public static void main(String[] args) {
        int[] freq = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int n = freq.length;

        BinaryIndexedTree b = new BinaryIndexedTree();
        b.constructBinaryIndexedTree(freq, n);

        System.out.println(b.getSum(5)); // 210 (10+20+30+40+50+60)

    }
}