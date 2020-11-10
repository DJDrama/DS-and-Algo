public class SnakePattern {
    // Print a matrix in snake pattern
    // 1 2 3 4
    // 5 6 7 8
    // 9 10 11 12
    // 13 14 15 16
    // --> 1 2 3 4 8 7 6 5 9 10 11 12 16 15 14 13
    void printSnakePattern(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        SnakePattern b = new SnakePattern();
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        b.printSnakePattern(arr);

    }

}
