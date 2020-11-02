public class SquareRoot {
    int getSquareRoot(int n) {
        int res = 0;
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (l+r) / 2;
            if (mid == n/mid)
                return mid;
            else if (n/mid < mid)
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