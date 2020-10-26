public class MaximumOccuringElement {
    int getMaximumOccuringElementInRange(int[] lArr, int[] rArr) {
        int[] arr = new int[1000];
        for (int i = 0; i < lArr.length; i++) {
            arr[lArr[i]] += 1;
            arr[rArr[i] + 1] -= 1;
        }
        int max = arr[0];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            if (max < arr[i]) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        // Given n ranges, find the max appearing element in the ranges
        // l[] = {1, 2, 5, 15}, r[] = {5, 8, 7, 18}
        // 5  range:(1-5, 2-8, 5-7, 15-18) --> {1, 2, 3, 4, 5},
        // {2, 3, 4, 5, 6, 7, 8}, {5, 6, 7}, {15, 16, 17, 18} 5 is the most frequent appearing element

        // 0<= l[i], r[i] < 1000
        MaximumOccuringElement m = new MaximumOccuringElement();
        int l[] = {1, 2, 3};
        int r[] = {3, 5, 7};
        System.out.println(m.getMaximumOccuringElementInRange(l, r)); // 3

        l = new int[]{1, 2, 5, 15};
        r = new int[]{5, 8, 7, 18};
        System.out.println(m.getMaximumOccuringElementInRange(l, r)); // 2
    }
}
