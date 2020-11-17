import java.util.Arrays;

public class LongestSubStringWithDistinctCharacter {
    // Longest Substring with Distinct Characters
    // "ABCDABC" --> 4 ("CDAB")
    // "AAA" --> 1
    // "" -> 0
    // "abaacdbab" --> 4 ("acdb")
    // O(n) time complexity, O(256) space complexity
    int longestSubStringCount(String s) {
        int n = s.length();
        int res = 0;
        int[] prev = new int[256];
        Arrays.fill(prev, -1);

        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, prev[s.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res, maxEnd);
            prev[s.charAt(j)] = j;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        LongestSubStringWithDistinctCharacter l = new LongestSubStringWithDistinctCharacter();
        String a = "abcdabc";
        // "abcdabc"
        // prev = {-1,-1...., -1, -1}
        // i=0
        // when j=0
        // i = Math.max(0, prev[a]=-1+1=0) = 0
        // maxEnd = 0-0+1 = 1
        // res = Math.max(0, 1) = 1
        // prev[a] = 0
        // when j=1
        // i = Math.max(0, prev[b]=-1+1=0) = 0
        // maxEnd = 1-0+1 = 2
        // res = Math.max(res, 2) = 2
        // prev[b] = 1
        // when j=2
        // i = Math.max(0, prev[c]+1)=0
        // maxEnd = 2-0+1 = 3 //abc
        // res = Math.max(res, 3) = 3
        // prev[c] = 2
        // when j=3
        // i = Math.max(0, prev[d]+1) = 0
        // maxEnd = 3-0+1 = 4 //abcd
        // res = Math.max(res, 4) = 4
        // prev[d] = 3
        // when j=4
        // i = Math.max(0, prev[a]=0+1) = 1
        // maxEnd = 4-1+1 = 3
        // res = Math.max(4, 3) = 4
        // prev[a] = 4
        // when j=5
        // i = Math.max(1, prev[b]=1+1=2) = 2
        // maxEnd = 5-2+1=4
        // res = Math.max(4, 4) = 4
        // prev[b] = 5
        // when j=6
        // i = Math.max(2, prev[c]=2+1)=3
        // maxEnd = 6-3+1 = 4
        // res = Math.max(4, 4)=4
        // prev[c] = 6
        // End Loop
        System.out.println(l.longestSubStringCount(a)); //4

    }
}