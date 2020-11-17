public class KMPAlgorithm {
    private void fillLPSEfficient(String pat, int[] lps) {
        int n = pat.length();
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len == 0)
                    lps[i++] = 0;
                else
                    len = lps[len - 1];
            }
        }
    }

    void findPattern(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = new int[m];
        fillLPSEfficient(pat, lps);

        int i = 0, j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(i - j);
                j = lps[j-1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        KMPAlgorithm k = new KMPAlgorithm();
        String txt = "abcdefg";
        String pat = "bcd";
        k.findPattern(txt, pat);

        System.out.println("------------------");
        
        txt = "aaaaab";
        pat = "aaaa";
        k.findPattern(txt, pat);

    }
}