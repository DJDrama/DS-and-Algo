import java.util.Arrays;

public class Prime {
    boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    void printPrimeFactors(int n){
        if(n<=1) return;
        while(n%2==0){
            System.out.print(2 + " " );
            n/=2;
        }
        while(n%3==0){
            System.out.print(3 + " " );
            n/=3;
        }
        for(int i=5; i*i<=n; i+=6){
            while(n%i==0){
                System.out.print(i + " ");
                n/=i;
            }
            while(n%(i+2)==0){
                System.out.print((i+2) + " ");
                n/=(i+2);
            }
        }

        if(n>3) // prime number left
            System.out.println(n);
        else
            System.out.println();
    }

    void printPrimesUntilN(int n){
        if(n<2) return; //No prime factors or number
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<=n; i++){
            if(isPrime[i])
                for(int j=i*i; j<=n; j+=i)
                    isPrime[j]=false;
        }
        for(int i=2; i<=n; i++){
            if(isPrime[i])
                System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Prime p = new Prime();

        int n=49;
        System.out.println(p.isPrime(n)); //false
        // 49 -> not dividable by 2 or 3
        // square root of 49 is 7
        // 49 is not dividable by 5(i) but dividable by 7(i+2)
        // so return false

        p.printPrimeFactors(49);  // 7 7
        p.printPrimeFactors(123);  // 3 41
        p.printPrimeFactors(125);  // 5 5 5

        p.printPrimesUntilN(17); // 2 3 5 7 11 13 17
        /**
         * 17 -> sqrt(17) is 4(i: 2 ~ 4)
         * i=2 (j=2*2)-> 4, 6, 8, 10, 12, 14, 16 should be false
         * i=3 (j=3*3)-> 9, 12, 15 should be false
         * i=4 (j=4*4)-> 16 should be false
         * 4, 6, 8, 9, 10, 12, 14, 15, 16 of isPrime Array is checked false
         * then 2, 3, 5, 7, 11, 13, 17 is checked true
         * so the answer is
         * 2, 3, 5, 7, 11, 13, 17
         **/
    }
}
