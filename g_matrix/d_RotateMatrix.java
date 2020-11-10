public class RotateMatrix {
    // Rotate a matrix by 90degree (Anti ClockWise)
    // 1 2 3 4
    // 5 6 7 8
    // 9 10 11 12
    // 13 14 15 16
    // -----------
    // 4 8 12 16
    // 3 7 11 15
    // 2 6 10 14
    // 1 5 9 13
    void rotateMatrixAntiClockWise(int[][] arr) {
        // 1. transpose matrix
        transposeMatrix(arr);
        // 2. reverse matrix vertically
        reverseMatrixVertically(arr);
    }

    void rotateMatrixClockWise(int[][] arr) {
        // 1. transpose matrix
        transposeMatrix(arr);
        // 2. reverse matrix horizontally
        reverseMatrixHorizontally(arr);
    }

    void transposeMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    void reverseMatrixVertically(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            int low = 0;
            int high = arr.length - 1;
            while (low < high) {
                int temp = arr[low][i];
                arr[low][i] = arr[high][i];
                arr[high][i] = temp;
                low++;
                high--;
            }
        }
    }

    void reverseMatrixHorizontally(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        // AntiClockwise
        rotateMatrix.rotateMatrixAntiClockWise(arr);

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        System.out.println();
        
        // Clockwise
        arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        rotateMatrix.rotateMatrixClockWise(arr);

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
