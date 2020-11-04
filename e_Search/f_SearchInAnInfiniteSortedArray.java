public class SearchInAnInfiniteSortedArray {

    // O(logn) time complexity, O(logn) space complexity
    int getIndexOfKey(int arr[], int x) {
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (arr[i] < x) {
            i *= 2; // multiply by 2
        }
        if (arr[i] == x)
            return i;
        return binarySearchRecursive(arr, i / 2 + 1, i - 1, x);
    }

    private int binarySearchRecursive(int[] arr, int l, int r, int x) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                return binarySearchRecursive(arr, mid + 1, r, x);
            else
                return binarySearchRecursive(arr, l, mid - 1, x);
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        SearchInAnInfiniteSortedArray s = new SearchInAnInfiniteSortedArray();

        // {1, 10, 15, 20, 40, 80, 90, 100, 120, 500, ... } //UnKnown size
        //just example
        int[] arr = {1, 10, 15, 20, 40, 80, 90, 100, 120, 500};
        int x = 120;

        /**
         * if arr[0] == 120, then return 0
         * starting from index i=1
         * arr[1] = 10 < 120, then i*=2
         * arr[2] = 15 < 120, then i*=2
         * arr[4] = 40 < 120, then i*=2
         * arr[8] = 120 == 120, so return 8
         */
        int index = s.getIndexOfKey(arr, x);
        System.out.println(index); // 8

        x = 100;
        /**
         * arr[0] = 1 != 100
         * arr[1] = 10 < 100, then i*=2
         * arr[2] = 15 < 100, then i*=2
         * arr[4] = 40 < 100, then i*=2
         * arr[8] = 120 > 100, so current i is 8
         *
         * binarySearch from i/2+1 = 5 to i-1 = 7
         * mid = 5+(7-5)/2 = 5+1 = 6
         * arr[6] = 90 < 100
         *
         * binarySearch from 7 to 7
         * mid = 7 + (7-7)/2 = 7
         * arr[7] = 100 == 100
         * so return 7
         */
        index = s.getIndexOfKey(arr, x);
        System.out.println(index);


    }
}