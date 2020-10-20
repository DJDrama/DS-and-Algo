public class Factorial {
    int factorialIterative(int n) {
        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        return num;
    }
    int factorialRecursive(int n){
        if(n<2) return 1;
        return n*factorialRecursive(n-1);
    }

    // 1 ~ 4 : 0
    // 5 ~ 9 : 1
    // 10 ~ 14 : 2
    // 15 ~ 19 : 3
    // 20 ~ 24 : 4
    // 25 ~ 29 : 6
    // 30 ~ 34 : 7
    // ...
    // Count Logic : n/5 + n/25 + n/125 + ...
    int countTrailingZerosOfFactorial(int n){
        int res=0;
        for(int i=5; i<=n; i*=5){
            res += n / i;
        }
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        int n = 5;
        System.out.println(f.factorialIterative(n)); // 120
        System.out.println(f.factorialRecursive(n)); // 120

        System.out.println(f.countTrailingZerosOfFactorial(n)); // 1(1)
        n=10;
        System.out.println(f.countTrailingZerosOfFactorial(n)); // 2(2)
        n=25;
        System.out.println(f.countTrailingZerosOfFactorial(n)); // 6(5 + 1)
        n=125;
        System.out.println(f.countTrailingZerosOfFactorial(n)); // 31(25 + 5 + 1)


    }
}