import java.util.HashMap;

public class LongestSubArrayWithEqualNumberOfZerosAndOnes {
    //Longest SubArray with equal no of 0s and 1s
    // {1, 0, 1, 1, 0, 0} --> 6
    // {1, 1, 1, 1} --> 0
    // {0, 0, 1, 1, 1, 1, 1, 0} --> 4
    // {1, 0, 1, 1, 1, 0, 0} --> 6
    int longestSubArrayCount(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int maxLength=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0)
                arr[i]=-1;
        }
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum == 0)
                maxLength = i+1;
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }else{
                maxLength = Math.max(maxLength, i-map.get(sum));
            }
        }
        return maxLength;
    }


}

class Main {
    public static void main(String[] args) {
        LongestSubArrayWithEqualNumberOfZerosAndOnes l = new LongestSubArrayWithEqualNumberOfZerosAndOnes();
        int[] a = new int[]{1, 0, 1, 1, 1, 0, 0};
        int count = l.longestSubArrayCount(a);
        System.out.println(count);

        a = new int[]{1, 1, 1, 1};
        count = l.longestSubArrayCount(a);
        System.out.println(count);

        a = new int[]{0, 0, 1, 1, 1, 1, 1, 0};
        count = l.longestSubArrayCount(a);
        System.out.println(count);

        a = new int[]{1, 0, 1, 1, 1, 0, 0};
        count = l.longestSubArrayCount(a);
        System.out.println(count);
    }
}
