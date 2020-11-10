public class SpiralTraversalOfMatrix {
    void spiralTraverse(int[][] arr) {
        int left = 0, right = arr[0].length - 1;
        int top = 0, bottom = arr.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++)
                System.out.print(arr[top][i] + " ");
            top++;
            for (int i = top; i <= bottom; i++)
                System.out.print(arr[i][right] + " ");
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(arr[bottom][i] + " ");
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(arr[i][left] + " ");
                left++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        SpiralTraversalOfMatrix s = new SpiralTraversalOfMatrix();
        int[][] arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        s.spiralTraverse(arr);

    }
}
