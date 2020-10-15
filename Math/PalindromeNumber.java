public class PalindromeNumber {

    boolean isPalindromeNumber(int n) {
        if (n / 10 == 0) return false;
        int temp = n;
        int rev = 0;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == n;
    }
}

class Main{
    public static void main(String[] args){
        PalindromeNumber p = new PalindromeNumber();

        int n = 12521;
        System.out.println(p.isPalindromeNumber(n)); //true

        n=1234;
        System.out.println(p.isPalindromeNumber(n)); //false
    }
}
