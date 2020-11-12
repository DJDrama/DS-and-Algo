public class ReverseStringByWords {
    // "welcome to World" --> "World to welcome"
    // "i love coding" --> "coding love i"
    // "abc" --> "abc"

    // O(n) time complexity
    // O(n) space complexity
    String getReversedStringByWords(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = c[i];
            if (ch == ' ') {
                reverseString(c, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(c, start, s.length() - 1);
        reverseString(c, 0, s.length() - 1);
        return new String(c);
    }

    private void reverseString(char[] c, int l, int r) {
        while (l <= r) {
            char temp = c[l];
            c[l] = c[r];
            c[r] = temp;
            l++;
            r--;
        }
    }

    // O(n) time complexity
    // O(n) space complexity
    String otherMethodUsingSplit(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--)
            sb.append(arr[i]).append(" ");
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}

class T {
    public static void main(String[] args) {
        ReverseStringByWords r = new ReverseStringByWords();

        String s = "Welcome To World";
        System.out.println(r.getReversedStringByWords(s));
        System.out.println(r.otherMethodUsingSplit(s));

        s = "i love coding";
        System.out.println(r.getReversedStringByWords(s));
        System.out.println(r.otherMethodUsingSplit(s));

        s = "abcdefg";
        System.out.println(r.getReversedStringByWords(s));
        System.out.println(r.otherMethodUsingSplit(s));
    }
}