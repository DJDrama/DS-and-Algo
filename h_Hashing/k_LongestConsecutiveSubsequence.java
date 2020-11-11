import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    // {1, 9, 3, 4, 2, 20} --> 4 (1, 3, 4, 2)
    // {8, 20, 7, 30} --> 2 (7, 8)
    // {20, 30, 40} --> 1
    // O(n) time complexity, O(n) space complexity
    int getMax(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int res=0;
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            if(!set.contains(arr[i]-1)){
                int cur=1;
                while(set.contains(cur+arr[i])){
                    cur++;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        LongestConsecutiveSubsequence l = new LongestConsecutiveSubsequence();
        int[] a = {1, 9, 3, 4, 2, 20};
        System.out.println(l.getMax(a));

        a = new int[]{8, 20, 7, 30};
        System.out.println(l.getMax(a));

        a = new int[]{20, 30, 40};
        System.out.println(l.getMax(a));

    }
}
