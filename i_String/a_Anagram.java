import java.util.HashSet;

public class Anagram {
    // Check for anagram
    // s1 = "listen", s2 = "silent" --> YES
    // s1="aaacb", s2="cabaa" --> YES
    // s1="aab", s2="bab" --> NO

    // O(n + 256) time complexity (2 Traversals)
    // O(256) space complexity
    boolean isAnagram(String s1, String s2){
        int[] c = new int[256];
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            c[ch]++;
            ch = s2.charAt(i);
            c[ch]--;
        }

        for(int i: c){
            if(i>0)
                return false;
        }
        return true;
    }

    // O(n) time complexity
    // O(n) space complexity
    boolean isAnagramUsingSet(String s1, String s2){
        HashSet<Character> s = new HashSet();
        for(int i=0; i<s1.length(); i++){
            s.add(s1.charAt(i));
            s.add(s2.charAt(i));
        }
        return s.size() == s1.length();
    }

}

class T{
    public static void main(String[] args){
        Anagram a = new Anagram();

        /** Using Array **/
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(a.isAnagram(s1, s2)); // True

        s1 = "aaacb";
        s2 = "cabaa";
        System.out.println(a.isAnagram(s1, s2)); // True

        s1 = "aab";
        s2 = "bab";
        System.out.println(a.isAnagram(s1, s2)); // False

        System.out.println("------------------------");

        /** Using Set **/
        s1 = "listen";
        s2 = "silent";
        System.out.println(a.isAnagram(s1, s2)); // True

        s1 = "aaacb";
        s2 = "cabaa";
        System.out.println(a.isAnagram(s1, s2)); // True

        s1 = "aab";
        s2 = "bab";
        System.out.println(a.isAnagram(s1, s2)); // False
    }
}