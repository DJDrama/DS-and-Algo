public class CountingSort {
    // {1, 4, 4, 1, 0, 1}, k=5 --> {0, 1, 1, 1, 4, 4}
    // {2, 1, 8, 9, 4} k=10 --> {1, 2, 4, 8, 9}
    // not a comparison based algorithm
    // O(n+k) time, O(n+k) aux space
    // stable
    // only for integers, not objects
    void countSort(int[] arr, int k){
        int[] temp = new int[k];

        for(int i=0; i<arr.length; i++)
            temp[arr[i]]++;

        for(int i=1; i<temp.length; i++)
            temp[i] += temp[i-1];

        int[] output = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            output[temp[arr[i]]-1] = arr[i];
            temp[arr[i]]--;
        }
        for(int i=0; i<arr.length; i++)
            arr[i] = output[i];

    }
}

class Main {
    public static void main(String[] args) {
        CountingSort s = new CountingSort();
        int arr[] = {1, 4, 4, 1, 0, 1};
        int k=5;

        // temp
        // {0, 1, 0, 0, 0}
        // {0, 1, 0, 0, 1}
        // {0, 1, 0, 0, 2}
        // {0, 2, 0, 0, 2}
        // {1, 2, 0, 0, 2}
        // {1, 3, 0, 0, 2}
        // temp
        // {1, 4, 4 ,4, 6}
        // ouput
        // {0, 1, 1, 1, 4, 4}
        s.countSort(arr, k);

        for(int num: arr)
            System.out.print(num+ " ");
    }

}
