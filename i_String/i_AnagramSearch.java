public class AnagramSearch {
    //Anagram Search
    // "helloforworld", "frog" --> true
    // "helloforworld", "lowo" --> false (must be continuous)

    /**
     * Naive
     **/
    // O((n-m)*m + 256) time complexity
    // O(256) space complexity
    boolean isPresent(String pat, String txt) {
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            if (isAnagram(pat, txt, i))
                return true;
        }
        return false;
    }

    boolean isAnagram(String pat, String txt, int i) {
        int[] count = new int[256];
        for (int j = 0; j < pat.length(); j++) {
            count[pat.charAt(j)]++;
            count[txt.charAt(i + j)]--;
        }
        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0) return false;
        }
        return true;
    }

    /**
     * Efficient
     **/
    // O(m+(n-m)*256) time complexity (where m=pattern length, n=txt length)
    // so Overall O(256*n) time complexity
    // O(256) space complexity
    boolean isPresentEfficient(String txt, String pat) {
        int[] ct = new int[256];
        int[] cp = new int[256];
        for (int i = 0; i < pat.length(); i++) {
            ct[txt.charAt(i)]++;
            cp[pat.charAt(i)]++;
        }
        for (int i = pat.length(); i < txt.length(); i++) {
            if (isSame(ct, cp))
                return true;
            ct[txt.charAt(i)]++;
            ct[txt.charAt(i - pat.length())]--;
        }
        return false;
    }

    private boolean isSame(int[] ct, int[] cp) {
        for (int i = 0; i < 256; i++) {
            if (ct[i] != cp[i])
                return false;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        AnagramSearch ana = new AnagramSearch();
        String a = "helloforworld";
        String b = "foor";
        System.out.println(ana.isPresent(b, a));

        b = "lofoo";
        System.out.println(ana.isPresentEfficient(a, b));
    }
}
