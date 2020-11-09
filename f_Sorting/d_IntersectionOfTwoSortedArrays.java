public class IntersectionOfTwoSortedArrays {
    // Intersection of two sorted arrays (common distinct element)
    // {2, 5, 8, 13, 15}, {1, 3, 8, 15, 18, 20, 25} -> 8, 15
    // {1, 1, 3, 3, 3}, {1, 1, 1, 1, 3, 5, 7} --> 1, 3

    // If not sorted just Arrays.sort(array) --> O(nlogn)

    // O(n) time complexity, O(1) space complexity
    void printIntersection(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int i = 0;
        int j = 0;
        while (i < aLength && j < bLength) {
            if(j>0 && b[j-1] == b[j]) { // SKIP DUPLICATES
                j++;
                continue;
            }
            if (a[i] < b[j])
                i++;
            else if (a[i] > b[j])
                j++;
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        IntersectionOfTwoSortedArrays m = new IntersectionOfTwoSortedArrays();
        int[] a = {2, 5, 8, 13, 15};
        int[] b = {1, 3, 8, 15, 18, 20, 25};
        m.printIntersection(a, b); // 8 15

        System.out.println();

        a = new int[]{1, 1, 3, 3, 3};
        b = new int[]{1, 1, 1, 1, 3, 5, 7};
        m.printIntersection(a, b); // 1, 3
    }
}
