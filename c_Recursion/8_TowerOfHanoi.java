public class TowerOfHanoi {
    void printTowerOfHanoi(int n, char from, char extra, char to){
        if(n==1){
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        printTowerOfHanoi(n-1, from, to, extra);
        System.out.println("Move " + n+ " from " + from + " to " + to);
        printTowerOfHanoi(n-1, extra, from, to);
    }
}

class Main {
    public static void main(String[] args) {
        TowerOfHanoi t = new TowerOfHanoi();

        int n=3;
        t.printTowerOfHanoi(n, 'A', 'B', 'C');

    }
}
