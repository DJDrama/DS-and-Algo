public class TransposeMatrix {
    void transposeMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();
        int[][] arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        // Transpose
        t.transposeMatrix(arr);

        for (int[] a : arr) {
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
