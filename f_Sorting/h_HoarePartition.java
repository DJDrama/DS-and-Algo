public class HoarePartition {
    // Hoare's Partition (Much Better than Lomuto Partition)
    // Pivot = First Element
    int hoarsePartition(int[] arr, int l, int r) {
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
            if (i >= j) return j;

            //swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

class Main {
    public static void main(String[] args) {
        HoarePartition l = new HoarePartition();
        int[] arr = new int[]{5, 3, 8, 4, 2, 7, 1, 10};
        int n = arr.length;

        // pivot = 5
        // i = -1, j = 8
        // do-while : i=0
        // do-while : j=6
        // swap(5, 1) {1, 3, 8, 4, 2, 7, 5, 10}
        // do-while : i=2
        // do-while : j=4
        // swap(2, 4) {1, 3, 2, 4, 8, 7, 5, 10}
        // do-while : i=4
        // do-while : j=3
        // i >= j : return 3
        l.hoarsePartition(arr, 0, n - 1);

        for (int num : arr)
            System.out.print(num + " ");
    }
}
