public class IndexOfFirstOccurrenceInSortedArray {

    // Naive Solution
    // O(n) time complexity, O(1) space complexity
    int indexOfFirstOccurrenceInSortedArrayNaive(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;

        return -1;
    }

    // Efficient Iterative Solution
    // O(logn) time complexity, O(1) space complexity
    int indexOfFirstOccurrenceInSortedArrayEfficientIterative(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key) {
                if(mid==0 || arr[mid-1] != arr[mid])
                    return mid;
                else
                    r = mid-1;
            } else if (key > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // Efficient Recursive Solution
    // O(logn) time complexity, O(logn) space complexity
    int indexOfFirstOccurrenceInSortedArrayEfficientRecursive(int[] arr, int key, int l, int r){
        if(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] > key)
                return indexOfFirstOccurrenceInSortedArrayEfficientRecursive(arr, key, l, mid-1);
            else if(arr[mid] < key)
                return indexOfFirstOccurrenceInSortedArrayEfficientRecursive(arr, key, mid+1, r);
            else{
                if(arr[mid]==0 || arr[mid-1]!=arr[mid])
                    return mid;
                else
                    return indexOfFirstOccurrenceInSortedArrayEfficientRecursive(arr, key, l, mid-1);
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        IndexOfFirstOccurrenceInSortedArray i = new IndexOfFirstOccurrenceInSortedArray();
        int[] arr = new int[]{1, 10, 10, 10, 20, 20, 40};
        int key = 20; // so the answer should be 1 (first occurrence of 10's index is 1)

        int index = i.indexOfFirstOccurrenceInSortedArrayNaive(arr, key);
        System.out.println("Index : " + index);

        index = i.indexOfFirstOccurrenceInSortedArrayEfficientIterative(arr, key);
        System.out.println("Index : " + index);

        index = i.indexOfFirstOccurrenceInSortedArrayEfficientRecursive(arr, key, 0, arr.length-1);
        System.out.println("Index : " + index);
    }
}