public class PalindromeCheck {

    // n/2 --> n
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    boolean isStringPalindrome(String s, int start, int end) {
        if (start >= end)
            return true;
        return s.charAt(start) == s.charAt(end)
                && isStringPalindrome(s, start+1, end-1);
    }
}

class Main {
    public static void main(String[] args) {
        PalindromeCheck p = new PalindromeCheck();

        String s = "abcba";
        int start = 0;
        int end = s.length() - 1;
        System.out.println(p.isStringPalindrome(s, start, end));
    }
}
