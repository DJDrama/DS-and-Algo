public class SquareRoot {
    int getSquareRoot(int n) {
        int res = 0;
        int l = 1; // root(0) == 0
        int r = n;
        while (l <= r) {
            int mid = l + r / 2;
            int mult = mid * mid;
            if (mult == n)
                return mid;
            else if (n < mult)
                r = mid - 1;
            else {
                l = mid + 1;
                res = mid;  // In case of mult is not equal to n (can be smaller but inclusive)
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        SquareRoot c = new SquareRoot();
        int x = 2147395599; // --> 2
        System.out.println(c.getSquareRoot(x));

        x = 14; // --> 3
        System.out.println(c.getSquareRoot(x));

        x = 25; // --> 5
        System.out.println(c.getSquareRoot(x));
    }
}