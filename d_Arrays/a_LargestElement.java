public class LargestElement {
    int getLargestElementIndex(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[res])
                res = i;
        }
        return res;
    }
}


class Main {
    public static void main(String[] args) {
        LargestElement l = new LargestElement();

        int[] arr = {1, 5, 2, 7, 6, 5};
        int largestIndex = l.getLargestElementIndex(arr);
        System.out.println(largestIndex + " " + arr[largestIndex]); // 3 7

    }
}