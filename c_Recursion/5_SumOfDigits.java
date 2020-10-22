public class SumOfDigits {
    int sumOfDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumOfDigits(n / 10);
    }

    //Non Recursive
    int sumOfDigitsNonRecursive(int n){
        int res=0;
        while(n>10){
            res+=n%10;
            n/=10;
        }
        res+=n;
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        SumOfDigits s = new SumOfDigits();

        int n = 123;
        System.out.println(s.sumOfDigits(n)); //6
        System.out.println(s.sumOfDigitsNonRecursive(n)); //6
    }
}
