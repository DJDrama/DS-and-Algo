public class FindAPeakElement {

    // Naive Solution
    // O(n) time complexity, O(1) space complexity
    int getPeakElementNaive(int[] arr) {
        if (arr.length == 1) return arr[0];

        int res = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                res = i;
        }
        return res == -1 ? -1 : arr[res];
    }

    // Efficient Solution
    // O(logn) time complexity, O(1) space complexity
    int getPeakElementEfficient(int[] arr) {
        int low = 0;
        int n = arr.length;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                return arr[mid];
            }
            if(mid>0 && arr[mid-1] >= arr[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        //Find a peak element
        // {5, 10, 20, 15, 7} --> 20
        // {10, 20, 15, 5, 23, 90, 67} --> 20 or 90
        // {80, 70, 60} --> 80

        FindAPeakElement f = new FindAPeakElement();

        int[] arr = {10, 20, 15, 5, 23, 90, 67};
        int element = f.getPeakElementNaive(arr);
        System.out.println(element); //90


        // low=0, high=6
        // mid=3 (arr[3] = 5)
        // since arr[2]=15 >= 5
        // high = mid-1 = 2
        // mid = 1 (arr[1] = 20)
        // 10 <= 20 && 20 >= 15
        // return 20
        element = f.getPeakElementEfficient(arr);
        System.out.println(element); //20
    }
}