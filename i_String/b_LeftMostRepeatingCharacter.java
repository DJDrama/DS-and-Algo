public class LeftMostRepeatingCharacter {
    // Leftmost Repeating Character
    // "abbcc" --> 1 (b is repeating and first b's index is 1)
    // "abcd" --> -1 (nothing is being repeated)

    // O(n+256) time complexity BUT 2 traversals
    // O(256) space complexity
    int getLeftMostRepeatingCharacterIndex(String s) {
        int[] c = new int[256];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (c[s.charAt(i)] > 1)
                return i;
        }
        return -1;
    }

    // O(n) time complexity BUT 1 traversal
    // O(256) space complexity
    int getLeftMostRepeatingCharacterIndexOneTraversal(String s) {
        int[] c = new int[256];
        int res = Integer.MAX_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            c[s.charAt(i)]++;
            if (c[s.charAt(i)] > 1)
                res = Math.min(res, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}

class T {
    public static void main(String[] args) {
        LeftMostRepeatingCharacter l = new LeftMostRepeatingCharacter();
        String s = "abbcc";
        System.out.println(l.getLeftMostRepeatingCharacterIndex(s)); // 1

        s = "abcdefg";
        System.out.println(l.getLeftMostRepeatingCharacterIndex(s)); // -1

        System.out.println("--------------------------------");

        s = "abbcc";
        System.out.println(l.getLeftMostRepeatingCharacterIndexOneTraversal(s)); // 1

        s = "abcdefg";
        System.out.println(l.getLeftMostRepeatingCharacterIndexOneTraversal(s)); // -1

        s = "apoqwera";
        System.out.println(l.getLeftMostRepeatingCharacterIndexOneTraversal(s)); // 0
    }
}