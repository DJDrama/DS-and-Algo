public class CountOccurrencesInSortedArray {
    // Naive Solution
    // O(n) time complexity, O(1) space complexity
    int countNaive(int[] arr, int key) {
        int res = 0;
        for (int i : arr) {
            if (i == key)
                res++;
        }
        return res;
    }

    // Efficient Solution
    // Using Binary Search
    // O(logn) time complexity, O(1) space complexity
    int countEfficient(int[] arr, int key) {
        int firstOccurrence = getFirstOccurrenceIndex(arr, key);
        if (firstOccurrence == -1)
            return 0;

        int lastOccurrence = getLastOccurrenceIndex(arr, key);
        return lastOccurrence - firstOccurrence + 1;
    }

    private int getFirstOccurrenceIndex(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key > arr[mid])
                l = mid + 1;
            else if (key < arr[mid])
                r = mid - 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    private int getLastOccurrenceIndex(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key > arr[mid])
                l = mid + 1;
            else if (key < arr[mid])
                r = mid - 1;
            else {
                if (mid == arr.length - 1 || arr[mid + 1] != arr[mid])
                    return mid;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

}

class Main {
    public static void main(String[] args) {
        CountOccurrencesInSortedArray c = new CountOccurrencesInSortedArray();
        int[] arr = {10, 20, 20, 20, 30, 30};
        int key = 20;

        int count = c.countNaive(arr, key);
        System.out.println("Count : " + count);

        count = c.countEfficient(arr, key);
        System.out.println("Count : " + count);
    }
}