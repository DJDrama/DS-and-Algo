public class MaximumSubArraySum {
    //Maximum Sum SubArray
    //{2, 3, -8 ,7,-1, 2, 3} --> 11(7, -1, 2, 3)
    //{5, 8, 3} --> 16
    int getMaximumSubArraySum(int[] arr){
        int res=0;
        int maxEnding = arr[0];
        for(int i=1; i<arr.length; i++){
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        MaximumSubArraySum m = new MaximumSubArraySum();
        int[] arr = {2, 3, -8 ,7,-1, 2, 3};
        System.out.println(m.getMaximumSubArraySum(arr)); // 11
        // 1) maxEnding = 2
        // 2) maxEnding = (2+3 = 5) > 3 --> 5
        // 3) maxEnding = (5-8 = -3) > -8 --> -3
        // 4) maxEnding = (-3+7 = 4) < 7 --> 7
        // 5) maxEnding = (7-1 = 6) > -1 --> 6
        // 6) maxEnding = (6+2 = 8) > 2 --> 8
        // 7) maxEnding = (8+3 = 11) > 3 --> 11 = res

        arr = new int[]{5, 8, 3};
        System.out.println(m.getMaximumSubArraySum(arr)); // 16

    }
}
