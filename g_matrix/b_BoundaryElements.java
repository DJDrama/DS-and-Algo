public class BoundaryElements {
    // Print Boundary Elements
    // 1 2 3 4
    // 5 6 7 8
    // 9 10 11 12
    // 13 14 15 16
    // --> 1 2 3 4 8 12 16 15 14 13 9 5
    void printBoundaryElements(int[][] arr) {
        if (arr.length == 1) {
            for (int i = 0; i < arr[0].length; i++) {
                System.out.print(arr[0][i] + " ");
            }
        } else if (arr[0].length == 1) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i][0] + " ");
        } else {
            int left = 0, top = 0;
            int right = arr[0].length - 1, bottom = arr.length - 1;
            for (int i = left; i <= right; i++)
                System.out.print(arr[top][i] + " ");
            top++;
            for (int i = top; i <= bottom; i++)
                System.out.print(arr[i][right] + " ");
            right--;
            for (int i = right; i >= left; i--)
                System.out.print(arr[bottom][i] + " ");
            bottom--;
            for (int i = bottom; i >= top; i--)
                System.out.print(arr[i][left] + " ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        BoundaryElements b = new BoundaryElements();
        int[][] arr = {{10, 20, 30, 40}};
        b.printBoundaryElements(arr);

        System.out.println();

        arr = new int[][]{
                {10},
                {15},
                {27},
                {32}
        };
        b.printBoundaryElements(arr);

        System.out.println();

        arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        b.printBoundaryElements(arr);
    }
}
