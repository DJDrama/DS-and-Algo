import java.util.HashMap;

public class LongestCommonSpan {
    // two binary arrays
    // {0, 1, 0, 0, 0, 0} &  {1, 0, 1, 0, 0, 1} --> 4 ({1, 0, 0, 0} == {0, 1, 0, 0})
    // {0, 1, 0, 1, 1, 1, 1} & {1, 1, 1, 1, 1, 0, 1} --> 6
    // O(n) time complexity, O(n) space complexity
    int getMaxLength(int[] a, int[] b) {
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i] - b[i];
        }
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
            if (sum == 0)
                maxLength = i + 1;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
        }
        return maxLength;
    }

}

class Main {
    public static void main(String[] args) {
        LongestCommonSpan l = new LongestCommonSpan();
        int[] a = {0, 1, 0, 1, 1, 1, 1};
        int[] b = {1, 1, 1, 1, 1, 0, 1};
        System.out.println(l.getMaxLength(a, b));
    }
}
