public class SubstringPermutation {
    // Given a string, print all those permutation
    // which don't contain "AB" as a substring
    // str="ABC"
    // output : ACB, BAC, BCA, CBA

    /** Naive **/
    void permuteNaive(String s, int l, int r) {
        if (l == r) {
            if (!s.contains("AB")) {
                System.out.print(s + " ");
            }
        } else {
            for (int i = l; i <= r; i++) {
                s = new String(swap(s, i, l));
                permuteNaive(s, l + 1, r);
                s = new String(swap(s, i, l));
            }
        }
    }

    /** BackTracking **/
    void permuteBackTracking(String s, int l, int r){
        if(l==r){
            System.out.print(s + " ");
        }else{
            for(int i=l; i<=r; i++){
                if(isSafe(s, l, i, r)) {
                    s = new String(swap(s, i, l));
                    permuteBackTracking(s, l + 1, r);
                    s = new String(swap(s, i, l));
                }
            }
        }

    }

    private boolean isSafe(String s, int l, int i, int r){
        // If previous character was 'A' and character
        // is 'B', then do not proceed and cut down
        // the recursion tree.
        if(l!=0 && s.charAt(l-1)=='A' && s.charAt(i)=='B')
            return false;

        // This condition is explicitly required for
        // cases when last two characters are "BA". We
        // do not want them to swapped and become "AB"
        if(r==(l+1) && s.charAt(i)=='A' && s.charAt(l)=='B')
            return false;

        return true;
    }
    private char[] swap(String s, int a, int b) {
        char[] arr = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}

class Main {
    public static void main(String[] args) {
        String str = "ABC";
        SubstringPermutation s = new SubstringPermutation();
        // s="ABC", l=0, r=2;
        // when i=0
        //      swap("ABC", 0, 0) --> "ABC"
        //      permuteNaive("ABC", 1, 2)
        //          s="ABC", l=1, r=2
        //          when i=1
        //              swap("ABC", 1, 1) --> "ABC"
        //              permuteNaive("ABC", 2, 2)
        //                  s="ABC", l=2, r=2
        //                  s.contains("AB") --> finish
        //              swap("ABC", 1, 1) --> "ABC"
        //          when i=2
        //              swap("ABC", 2, 1) --> "ACB"
        //              permuteNaive("ACB", 2, 2)
        //                  s="ACB", l=2, r=2
        //                  !s.contains("AB") --> print("ACB")
        //              swap("ABC", 2, 1) --> "ABC" (return to original string)
        //      swap("ABC", 0, 0) --> "ABC"
        // when i=1
        //      swap("ABC", 1, 0) --> "BAC"
        //      permuteNaive("BAC", 1, 2)
        //          s="BAC", l=1, r=2
        //          when i=1
        //              swap("BAC", 1, 1) --> "BAC"
        //              permuteNaive("BAC", 2, 2)
        //                  s="BAC", l=2, r=2
        //                  !s.contains("AB") --> print("BAC")
        //              swap("BAC", 1, 1) --> "BAC"
        //          when i=2
        //              swap("BAC", 2, 1) --> "BCA"
        //              permuteNaive("BCA", 2, 2)
        //                  s="BCA", l=2, r=2
        //                  !s.contains("BCA") --> print("BCA")
        //              swap("BCA", 2, 1) --> "BAC" (return to original string)
        //      swap("BAC", 1, 0) --> "ABC"
        // and continues...

        s.permuteNaive(str, 0, str.length() - 1);

        System.out.println();

        s.permuteBackTracking(str, 0, str.length()-1);
    }
}
