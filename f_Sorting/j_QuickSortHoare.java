public class QuickSortHoare {
    void quickSortHoare(int[] arr, int l, int r) {
        if (l < r) {
            int p = hoarePartition(arr, l, r);
            quickSortHoare(arr, l, p);
            quickSortHoare(arr, p + 1, r);
        }
    }

    private int hoarePartition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l - 1;
        int j = r + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if(i>=j)
                return j;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

    }
}

class Main {
    public static void main(String[] args) {
        QuickSortHoare q = new QuickSortHoare();
        int[] arr = new int[]{8, 4, 7, 9, 3, 10, 5};
        int n = arr.length;

        q.quickSortHoare(arr, 0, n - 1);

        for (int num : arr)
            System.out.print(num + " ");
    }
}
