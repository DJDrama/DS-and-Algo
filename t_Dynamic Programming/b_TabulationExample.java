public class TabulationExample {
    /**
     * Tabulation: Bottom Up
     **/
    int fibonacciTab(int n) {
        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = 1;
        for (int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }
}

class Main {
    public static void main(String[] args) {
        int n = 10;
        TabulationExample t = new TabulationExample();
        System.out.println(t.fibonacciTab(n)); //55
    }
}
