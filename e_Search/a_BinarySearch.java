public class BinarySearch {
    // O(logn) time complexity
    // O(1) space complexity
    int binarySearchIterative(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key == arr[mid])
                return mid;
            else if (key > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // O(logn) time complexity
    // O(logn) space complexity
    int binarySearchRecursive(int[] arr, int key, int l, int r) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key)
                return mid;
            else if (key > arr[mid])
                return binarySearchRecursive(arr, key, mid + 1, r);
            else
                return binarySearchRecursive(arr, key, l, mid - 1);
        }
        return -1;
    }

}

class Main {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {10, 20, 30, 40, 50, 60};
        int key = 50;
        int index = bs.binarySearchIterative(arr, key);
        System.out.println("Index: " + index + ", Value : " + arr[index]);

        index = bs.binarySearchRecursive(arr, key, 0, arr.length - 1);
        System.out.println("Index: " + index + ", Value : " + arr[index]);

    }
}