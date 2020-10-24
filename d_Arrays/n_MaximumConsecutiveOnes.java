public class MaximumConsecutiveOnes {
    // Maximum consecutive 1s
    // {0, 1, 1, 0, 1, 0} --> 2
    // {1, 1, 1, 1} --> 4
    // {0, 0, 0} --> 0
    // {1, 0, 1, 1, 1, 1, 0, 1} --> 4
    // O(n) time complexity, O(1) space complexity
    int getMaximumConsecutiveOnes(int[] arr){
        int res=0;
        int count=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1){
                count++;
                res = Math.max(res, count);
            }else{
                count=0;
            }
        }
        return res;
    }


}

class Main {
    public static void main(String[] args) {
        MaximumConsecutiveOnes m = new MaximumConsecutiveOnes();
        int[] arr = new int[]{1, 0, 1, 1, 1, 1, 0, 1};
        System.out.println(m.getMaximumConsecutiveOnes(arr));

        arr = new int[]{0, 1, 1, 0, 1, 0};
        System.out.println(m.getMaximumConsecutiveOnes(arr));
    }
}
