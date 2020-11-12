public class LeftMostNonRepeatingCharacter {
    // "helloforhello" --> 5
    // ('f' is the first character that does not repeat)
    // "abcabc" --> -1
    // "apple" --> 0('a')

    // O(n+256) time complexity BUT 2 traversals
    // O(256) space complexity
    int getLeftMostNonRepeatingCharacterIndexTwoTraversals(String s){
        int[] c = new int[256];
        for(int i=0; i<s.length(); i++){
            c[s.charAt(i)]++;
        }
        for(int i=0; i<c.length; i++){
            if(c[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}

class T {
    public static void main(String[] args) {
        LeftMostNonRepeatingCharacter l = new LeftMostNonRepeatingCharacter();

        String s = "HelloForHello";
        System.out.println(l.getLeftMostNonRepeatingCharacterIndexTwoTraversals(s)); // 5 (f)
    }
}