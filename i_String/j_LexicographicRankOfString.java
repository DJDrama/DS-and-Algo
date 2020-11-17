public class LexicographicRankOfString {
    // Lexicographic Rank
    // "BAC", 3 --> ABC, ACB, BAC, BCA, CAB, CBA
    // "CBA", 6
    // "DCBA", 24
    // "STRING", 598
    // O(n*256) time complexity
    // O(256) space complexity
    int lexicographicRank(String str) {
        int res = 1;
        int n = str.length();
        int mul = fact(n);
        int[] count = new int[256];

        for (int i = 0; i < n; i++)
            count[str.charAt(i)]++;

        for (int i = 1; i < 256; i++)
            count[i] += count[i - 1];

        for (int i = 0; i < n - 1; i++) {
            mul /= n - i;
            res += count[str.charAt(i) - 1] * mul;
            for (int j = str.charAt(i); j < 256; j++)
                count[j]--;
        }
        return res;
    }

    private int fact(int n) {
        return n <= 1 ? 1 : n * fact(n - 1);
    }
}

class Test {
    public static void main(String[] args) {
        LexicographicRankOfString l = new LexicographicRankOfString();
        String a = "BAC";
        // "BAC" --> fact(3)=6
        // count[] will be 000...111...222222....333333...
        // when i=0, n=3
        // mul = 6/3=2
        // res += count[B-1]=1*2 = 1+2 = 3
        // count[] will be 0000...1111...11111...2222...
        // i=1, n=3
        // mul = 6/2=3
        // res += count[A-1]=0 * mul = 0 = 3
        // count[] will be 000 ... 0000 ... 0000 ... 1111...
        // i=2, n=3
        // mul = 6/1 = 6
        // res+= count[C-1]=0 * mul = 0 = 3
        // count[] will be 000....0000.00000.0000.....
        // end loop
        System.out.println(l.lexicographicRank(a)); //3

        a = "STRING";
        System.out.println(l.lexicographicRank(a)); //598
    }
}