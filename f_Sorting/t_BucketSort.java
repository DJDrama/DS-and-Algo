import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    // {20, 80, 40, 30, 70}, k=4 --> {20, 30, 40, 70, 80}
    // max = 80, minimum=0 --> range from 0 to 80 and divide into (k=4) buckets (20)
    // Best Case : O(n) (data is uniformly distributed)
    // Worst Case : O(n^2)
    // If we use Insertion sort to sort the individual buckets, then O(n^2)
    // If we use O(nlogn) algorithm to sort individual buckets, then O(nlogn)
    void bucketSort(int[] arr, int k) {
        int n = arr.length;

        //finding max
        int maxValue = arr[0];
        for (int i = 1; i < n; i++)
            maxValue = Math.max(maxValue, arr[i]);

        // because if maxvalue is 80 and divide 80 to 80 --> 1
        // 80 divide to 81 --> 0
        maxValue++;

        // Fill buckets
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();

        for(int i=0; i<k; i++)
            bucket.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int bi = (k * arr[i]) / maxValue; //ex {{20}, {40, 30}, {80, 70}, {}}
            bucket.get(bi).add(arr[i]);
        }

        // Sort Bucket
        for (int i = 0; i < k; i++)
            Collections.sort(bucket.get(i));

        // Merge Bucket
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                arr[index++] = bucket.get(i).get(j);
            }
        }

    }
}

class Main {
    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        int[] arr = {20, 80, 40, 30, 70};
        int k = 4; // Buckets

        b.bucketSort(arr, k);

        for (int num : arr)
            System.out.print(num + " ");
    }

}
