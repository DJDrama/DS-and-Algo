public class PatternSearching {
    // Pattern Searching
    // "AAAAA", "AAA" --> 0 1 2
    // "ABCABCD", "ABD" --> No Present
    // n = text length, m = pattern length

    // O((n-m+1)*m) time complexity
    // O(1) space complexity
    void printIndicesOfPatternNaive(String s, String pat) {
        for (int i = 0; i <= s.length() - pat.length(); i++) {
            int j;
            for (j = 0; j < pat.length(); j++) {
                if (s.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == pat.length())
                System.out.print(i + " ");
        }
    }

    // Patter for DISTINCT characters
    // "ABCAAAD", "ABD" --> empty
    // "ABCABCDABCD", "ABCD" --> 3 7
    // ONLY FOR DISTINCT CHRACTERS PATTERN
    // O((n-m+1)*m) time complexity, Theta(n) complexity
    void patternSearchingForDistinctCharactersPattern(String s, String pat) {
        int n = s.length();
        int m = pat.length();

        for (int i = 0; i < n - m + 1; ) {
            int j;
            for (j = 0; j < m; j++) {
                if (s.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == m)
                System.out.print(i + " ");
            if (j == 0)
                i++;
            else
                i += j;
        }
    }
}

class T {
    public static void main(String[] args) {
        PatternSearching r = new PatternSearching();
        String s = "AAAAA";
        String pattern = "AAA";
        r.printIndicesOfPatternNaive(s, pattern); // 0 1 2

        System.out.println();

        s = "ABCABCD";
        pattern = "ABCD";
        r.printIndicesOfPatternNaive(s, pattern); // 3

        System.out.println();
        System.out.println("---------------------------------");

        s = "ABCABCD";
        pattern = "ABCD";
        r.patternSearchingForDistinctCharactersPattern(s, pattern); // 3
    }
}