public class CheckForRotation {
    //check for rotation
    //"ABCD", "BCDA" --> true
    //"ABAAA", "BAAAA" --> true
    //"ABAB", "ABBA" --> false
    boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return s1.concat(s1).indexOf(s2)>-1;
    }
}

class Test {
    public static void main(String[] args) {
        CheckForRotation c = new CheckForRotation();
        String a = "abaaa";
        String b = "baaaa";
        System.out.println(c.isRotation(a, b));
    }
}