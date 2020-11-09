public class MergeSort {
    /**
     * STABLE SORT, DIVIDE & CONQUER
     **/
    // O(nlogn) time complexity overall
    void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    // O(n) time complexity, O(n) space complexity
    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + j + 1];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
    }

}

class Main {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int a[] = new int[]{10, 5, 30, 15, 7};
        m.mergeSort(a, 0, a.length - 1);

        for (int num : a)
            System.out.print(num + " ");
    }
}
