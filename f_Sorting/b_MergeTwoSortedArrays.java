public class MergeTwoSortedArrays {

    // O(n) time complexity, O(1) space complexity
    void printMergeTwoSortedArrays(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;

        int i = 0, j = 0;
        while (i < aLength && j < bLength) {
            if (a[i] < b[j]) {
                System.out.print(a[i++] + " ");
            } else {
                System.out.print(b[j++] + " ");
            }
        }
        while (i < aLength)
            System.out.print(a[i++] + " ");
        while (j < bLength)
            System.out.print(b[j++] + " ");
    }
}

class Main {
    public static void main(String[] args) {
        MergeTwoSortedArrays m = new MergeTwoSortedArrays();
        int[] a = new int[]{10, 15, 20, 40};
        int[] b = new int[]{5, 6, 6, 6, 10, 15};
        m.printMergeTwoSortedArrays(a, b);
    }
}
