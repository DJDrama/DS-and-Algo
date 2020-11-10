public class CountInversionsInArray {
    // Count Inversions in an array
    // A Pair forms an inversion when i < j and arr[i] > arr[j]
    // {2, 4, 1, 3, 5} --> 3  ({4, 1}, {4, 3}, {2, 1})
    // {10, 20, 30, 40} --> 0
    // {40, 30, 20, 10} --> 6 = (4*3)/2
    // O(nlogn) time, o(n) space
    int countInversion(int arr[], int l, int r) {
        int res = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            res += countInversion(arr, l, mid);
            res += countInversion(arr, mid + 1, r);
            res += countAndMerge(arr, l, mid, r);
        }
        return res;
    }

    int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int res = 0;
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i];
                i++;
            } else {
                arr[k++] = right[j];
                j++;

                // ex) {2, 5, 8, 11} & {3, 6, 9, 13}
                // if 5 is greater than 3, then 8, 11 will be also greater than 3
                // so n1=4 minus i(which is 1 when 5)
                // 4-1 = 3 --> so res += 3
                res += n1 - i;
            }
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];

        return res;
    }

}

class Main {
    public static void main(String[] args) {
        CountInversionsInArray c = new CountInversionsInArray();
        int[] a = {2, 5, 8, 11, 3, 6, 9, 13};

        int res = c.countInversion(a, 0, a.length - 1);  // 6 (3 + 2 + 1)
        System.out.println(res);

    }
}
