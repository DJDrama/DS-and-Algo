public class LomutoPartition {
    // Pivot is always the last one
    int lomutoPartition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for(int j=l; j<=r-1; j++){ // until the pivot
            if(arr[j] < pivot){
                i++;

                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i+1;
    }
}

class Main {
    public static void main(String[] args) {
        LomutoPartition l = new LomutoPartition();
        int[] arr = new int[]{10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        // pivot is 70
        // i = -1
        // when j=0, 10 < 70 --> i=0, swap(10, 10)
        // when j=1, 80 > 70 --> continue
        // when j=2, 30 < 70 --> i=1, swap(80, 30)
        // {10, 30, 80, 90, 40, 50, 70}
        // when j=3, 90 > 70 --> continue
        // when j=4, 40 < 70 --> i=2, swap(80, 40)
        // {10, 30, 40, 90, 80, 50, 70}
        // when j=5, 50 < 70 --> i=3, swap(90, 50)
        // {10, 30, 40, 50, 80, 90, 70}
        // end loop
        // i+1=4, r=6 --> swap(80, 70)
        // {10, 30, 40, 50, 70, 90, 80}

        l.lomutoPartition(arr, 0, n - 1);

        for (int num : arr)
            System.out.print(num + " ");
    }
}
