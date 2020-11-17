public class LongestProperPrefixSuffixArray {
    // Constructing Longest Proper Prefix Suffix Array
    // ex) proper prefix --> "abcd" --> "a", "ab", "abc" (NOT "abcd")
    // "ababc", {0, 0, 1, 2, 0}
    // "aaaa", {0, 1, 2, 3}
    // "abcd", {0, 0, 0, 0}
    // "ababab", {0, 0, 1, 2, 3, 4}
    // "abacabad", {0, 0, 1, 0, 1, 2, 3, 0}
    // "abbabb", {0, 0, 0, 1, 2, 3}

    /**
     * Naive
     **/
    // O(n^3) time complexity
    void fillLpsNaive(String str, int[] lps) {
        for (int i = 0; i < str.length(); i++) {
            lps[i] = longPropPreSuff(str, i + 1);
        }
    }

    int longPropPreSuff(String str, int n) {
        for (int len = n - 1; len > 0; len--) {
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != str.charAt(n - len + i))
                    flag = false;
            }
            if (flag)
                return len;
        }
        return 0;
    }

    /**
     * Efficient
     **/
    // Theta(n) time complexity
    void fillLPSEfficient(String str, int[] lps) {
        int n = str.length();
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i++] = len;
            }else{
                if(len==0)
                    lps[i++]=0;
                else
                    len = lps[len-1];
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        LongestProperPrefixSuffixArray l = new LongestProperPrefixSuffixArray();
        String a = "ababc"; // {0, 0, 1, 2, 0}
        int[] lps = new int[a.length()];

        l.fillLpsNaive(a, lps);
        for (int num : lps)
            System.out.print(num + " ");

        System.out.println("\n-----------------------------");

        // "ababc", n=5
        // len=0, lps[0]=0, i=1
        // -- while --
        // str.charAt(1) = b, str.charAt(0) = a
        // else -> len=0 --> lps[1]=0, i++=2
        // len=0, i=2, n=5
        // str.charAt(2) = a, str.charAt(0) = a
        // len++=1, lps[2]=1, i++=3
        // {0, 0, 1, , }
        // len=1, i=3, n=5
        // str.charAt(3) = b, str.charAt(1)=b
        // len++=2, lps[3]=2, i++=4
        // {0, 0, 1, 2, }
        // len=2, i=4, n=5
        // str.charAt(4) = b, str.charAt(2) = a
        // len = lps[2-1] = 0
        // len=0, i=4, n=5
        // str.charAt(4) = b, str.charAt(0) = a
        // lps[4] = 0, i++=5
        // {0, 0, 1, 2, 0}
        // -- end while --
        l.fillLPSEfficient(a, lps);
        for (int num : lps)
            System.out.print(num + " ");

    }
}
