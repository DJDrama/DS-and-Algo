public class SearchInRowWiseAndColumnWiseSortedMatrix {
    // Search in row-wise and column-wise sorted matrix
    // 10 20 30 40
    // 15 25 35 45
    // 27 29 37 48
    // 32 33 39 50
    // x=29 --> (2, 1)
    // Naive --> O(row*col)
    // Efficient --> O(row+col)
    int[] search(int[][] arr, int key){
        int top=0;
        int right = arr[0].length - 1;
        while(top<arr.length && right>=0){
            if(arr[top][right] == key)
                return new int[]{top, right};
            else if(key < arr[top][right])
                right--;
            else
                top++;
        }
        return new int[]{-1, -1};
    }
}

class Main {
    public static void main(String[] args) {
        SearchInRowWiseAndColumnWiseSortedMatrix s = new SearchInRowWiseAndColumnWiseSortedMatrix();
        int[][] arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        int key = 37;
        int[] res = s.search(arr, key);
        System.out.println("Found At Index : " + res[0] + ", " + res[1]);

        key=31;
        res = s.search(arr, key);
        System.out.println("Found At Index : " + res[0] + ", " + res[1]);

    }
}
