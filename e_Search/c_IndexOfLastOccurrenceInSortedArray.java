public class IndexOfLastOccurrenceInSortedArray {

    // Naive Solution
    // O(n) time complexity, O(1) space complexity
    int indexOfLastOccurrenceInSortedArrayNaive(int[] arr, int key) {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i] == key)
                return i;

        return -1;
    }

    // Efficient Iterative Solution
    // O(logn) time complexity, O(1) space complexity
    int indexOfLastOccurrenceInSortedArrayEfficientIterative(int[] arr, int key) {
       int l=0;
       int r=arr.length-1;
       while(l<=r){
           int mid = l+(r-l)/2;
           if(key>arr[mid])
               l = mid+1;
           else if(key<arr[mid])
               r=mid-1;
           else{
               if(arr[mid]==arr.length-1 || arr[mid+1]!=arr[mid])
                   return mid;
               else
                   l = mid+1;
           }
       }
       return -1;
    }

    // Efficient Recursive Solution
    // O(logn) time complexity, O(logn) space complexity
    int indexOfLastOccurrenceInSortedArrayEfficientRecursive(int[] arr, int key, int l, int r) {
        if(l<=r){
            int mid = l+(r-l)/2;
            if(key > arr[mid])
                return indexOfLastOccurrenceInSortedArrayEfficientRecursive(arr, key, mid+1, r);
            else if(key < arr[mid])
                return indexOfLastOccurrenceInSortedArrayEfficientRecursive(arr, key, l, mid-1);
            else{
                if(arr[mid] == arr.length-1 || arr[mid+1] != arr[mid])
                    return mid;
                else
                    return indexOfLastOccurrenceInSortedArrayEfficientRecursive(arr, key, mid+1, r);
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        IndexOfLastOccurrenceInSortedArray i = new IndexOfLastOccurrenceInSortedArray();
        int[] arr = new int[]{1, 10, 10, 10, 20, 20, 40};
        int key = 20;

        int index = i.indexOfLastOccurrenceInSortedArrayNaive(arr, key);
        System.out.println("Index : " + index);

        index = i.indexOfLastOccurrenceInSortedArrayEfficientIterative(arr, key);
        System.out.println("Index : " + index);

        index = i.indexOfLastOccurrenceInSortedArrayEfficientRecursive(arr, key, 0, arr.length - 1);
        System.out.println("Index : " + index);
    }
}