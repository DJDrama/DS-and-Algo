public class SearchInASortedArrayWithRotation {

    // O(logn) time complexity, O(1) space complexity
    int getIndex(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] >= arr[l]) {
                if (x >= arr[l] && x < arr[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (x > arr[mid] && x <= arr[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        SearchInASortedArrayWithRotation s = new SearchInASortedArrayWithRotation();

        int[] arr = {10, 20, 40, 60, 5, 8};
        int x = 5;
        /**
         * l=0, r=5
         * mid = 2
         * arr[2] = 40 != 5
         * arr[2] = 40 > arr[0] = 10
         * 5 < 10 so l = 2 + 1 = 3
         *
         * l=3, r=5
         * mid = 4
         * arr[4] = 5 == 5
         * return 4;
         */
        int index = s.getIndex(arr, x);
        System.out.println(index);

        x = 10;
        /**
         * l=0, r=5, mid=2
         * arr[2]=40 != 10
         * arr[2] > arr[0]
         * so, 10>=10 && 10<40
         * r = mid-1 = 1
         *
         * l=0, r=1, mid=0
         * arr[mid] = arr[0] = 10 = 10
         * so return 0
         */
        index = s.getIndex(arr, x);
        System.out.println(index);
    }
}