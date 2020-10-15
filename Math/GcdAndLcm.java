public class GcdAndLcm {
    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
}

class Main{
    public static void main(String[] args){
        GcdAndLcm gal = new GcdAndLcm();

        int x=24, y=6;

        // Great Common Divisor
        System.out.println(gal.gcd(x, y));  // 6
        // 24, 6
        // -> gcd(24, 6)
        // -> gcd(6, 0)
        // -> b==0
        // so return 6

        // Least Common Multiple
        System.out.println(gal.lcm(x, y));  // 24
        // 24, 6
        // 24 * 6 = 144
        // 144 / gcd(24, b)
        // 144 / 6 = 24
    }
}