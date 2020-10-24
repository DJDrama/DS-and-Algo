public class LongestEvenOddSubArray {
    //Longest even-odd subarray
    //{10, 12, 14, 7, 8} --> 3 (even, even, even, odd, even)
    //{7, 10, 13, 14} --> 4 (odd, even, odd, even)
    //{10, 12, 8, 4} --> 1 (even, even, even, even)
    //O(n), O(1)
    int getLongestEvenOddSubArrayElementCount(int[] arr){
        int res=0;
        int count=1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]%2==0 && arr[i-1]%2!=0 ||
            arr[i]%2!=0 && arr[i-1]%2==0){
                count++;
                res = Math.max(res, count);
            }else{
                count=1;
            }
        }
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        LongestEvenOddSubArray m = new LongestEvenOddSubArray();
        int[] arr = new int[]{5, 10, 20, 6, 3, 8};
        System.out.println(m.getLongestEvenOddSubArrayElementCount(arr)); // 3

        arr = new int[]{7, 10, 13, 14};
        System.out.println(m.getLongestEvenOddSubArrayElementCount(arr)); // 4


    }
}
