public class JosephusProblem {
    int survivorFromZeroIndex(int n, int k) {
        if (n == 1) return 0;
        return (survivorFromZeroIndex(n - 1, k) + k) % n;
    }

    int survivorFromOneIndex(int n, int k) {
        return survivorFromZeroIndex(n, k) + 1;
    }
}

class Main {
    public static void main(String[] args) {
        JosephusProblem j = new JosephusProblem();

        int n = 7;
        int k = 3;
        System.out.println("Survivor no: " + j.survivorFromZeroIndex(n, k)); //3

        n = 5;
        k = 3;
        System.out.println("Survivor no: " + j.survivorFromZeroIndex(n, k)); //3

        n = 8;
        k = 2;
        System.out.println("Survivor no: " + j.survivorFromZeroIndex(n, k)); //0

    }
}
