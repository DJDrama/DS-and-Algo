public class TripletOfSum {
    // Given an SORTED array and a number x,
    // we need to find if there is a triplet in the array with num equals to x
    // {2, 3, 4, 8, 9, 20, 40}, x = 32
    // YES (4 + 8 + 20)
    // O(n^2)
    boolean hasTripletOfSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            if (hasPair(arr, i + 1, arr.length - 1, sum - arr[i])){
                return true;
            }
        }
        return false;
    }

    boolean hasPair(int[] arr, int l, int r, int sum) {
        while (l < r) {
            if (arr[l] + arr[r] == sum)
                return true;
            else if (arr[l] + arr[r] > sum)
                r--;
            else
                l++;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        TripletOfSum p = new TripletOfSum();
        int[] arr = {2, 3, 4, 8, 9, 20, 40};
        int sum = 27;

        boolean hasPair = p.hasTripletOfSum(arr, sum); // 3 + 4 + 20 = 27
        System.out.println(hasPair);
    }
}