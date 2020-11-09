public class UnionOfTwoSortedArrays {
    // Union Of Two Sorted Arrays
    // {3, 8, 10}, {2, 8, 9, 10, 15} --> 2, 3, 8, 9, 10, 15
    // {2, 3, 3, 3, 4}, {4, 4} --> 2, 3, 4
    // O(m+n), O(1)
    void presentUnion(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int i = 0, j = 0;
        while (i < aLength && j < bLength) {
            if (i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }
            if (j > 0 && b[j - 1] == b[j]) {
                j++;
                continue;
            }
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        while (i < aLength) {
            if (i == 0 || a[i - 1] != a[i]) {
                System.out.print(a[i] + " ");
                i++;
            }
        }
        while (j < bLength) {
            if (j == 0 || b[j - 1] != b[j]) {
                System.out.println(b[j] + " ");
                j++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        UnionOfTwoSortedArrays m = new UnionOfTwoSortedArrays();
        int[] a = {3, 8, 10};
        int[] b = {2, 8, 9, 10, 15};

        m.presentUnion(a, b);

        System.out.println();

        a = new int[]{2, 3, 3, 3, 4, 5, 5, 5};
        b = new int[]{4, 4};
        m.presentUnion(a, b);
    }
}
