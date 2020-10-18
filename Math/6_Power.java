public class Power {
    int computePower(int x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0)
            return computePower(x, n / 2) * computePower(x, n / 2);
        else
            return computePower(x, n - 1) * x;
    }
}

class Main {
    public static void main(String[] args) {
        Power p = new Power();
        int x = 3;
        int n = 5;
        System.out.println(p.computePower(3, 5));
        /**
         * 3^5 = 243
         * 5%2!=0, so 3*computePower(3, 4)
         * 3*computePower(3, 2)*computePower(3, 2)
         * 3*computePower(3, 1)*computePower(3, 1)*computePower(3, 1)*computePower(3, 1)
         * 3*3*computePower(3, 0)*3*computePower(3, 0) ...
         * since computePower(3, 0) will return 1
         * 3*3*1*3*1*3*1*3*1 = 243
         */
    }
}
