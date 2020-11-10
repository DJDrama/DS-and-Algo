public class QuickSortLomuto {
    // QuickSort Using Lomuto Partition
    void quickSortLomuto(int[] arr, int l, int r) {
        if (l < r) {
            int p = lomutoPartition(arr, l, r);
            quickSortLomuto(arr, l, p - 1);
            quickSortLomuto(arr, p + 1, r);
        }
    }
    private int lomutoPartition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i=l-1;
        for(int j=l; j<=r-1; j++){
            if(arr[j] < pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // last swap
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }

}

class Main {
    public static void main(String[] args) {
        QuickSortLomuto q = new QuickSortLomuto();
        int[] arr = new int[]{8, 4, 7, 9, 3, 10, 5};
        int n = arr.length;

        q.quickSortLomuto(arr, 0, n-1);

        for (int num : arr)
            System.out.print(num + " ");
    }
}
