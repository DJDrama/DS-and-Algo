public class CountingDistinctRowsInABinaryMatrix {
    // count distinct rows in a binary matrix
    // {1, 0, 0}
    // {1, 1, 1}
    // {1, 0, 0}
    // {1, 1, 1} // 2

    // {1, 1, 0, 0}
    // {1, 1, 0, 0}
    // {1, 1, 0, 0}
    // {1, 1, 0, 0} // 1
    private final int[][] arr;
    private final int row;
    private final int col;
    private final TrieNode root;

    CountingDistinctRowsInABinaryMatrix(int[][] arr, int row, int col) {
        this.arr = arr;
        this.row = row;
        this.col = col;
        root = new TrieNode();
    }

    int countDistinctRows() {
        int res = 0;
        for (int i = 0; i < this.row; i++) {
            if (insert(root, i))
                res++;
        }
        return res;
    }

    private boolean insert(TrieNode root, int row) {
        TrieNode curr = root;
        boolean flag = false;
        for (int i = 0; i < col; i++) {
            int index = arr[row][i];

            //if first insert, then flag becomes true
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
                flag = true;
            }
            curr = curr.children[index];
        }
        return flag;
    }


    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // 2: 0 or 1
    }
}

class Main {
    public static void main(String[] args) {
        int row = 4;
        int column = 3;
        int[][] arr = {
                {0, 1, 0},
                {1, 1, 1},
                {1, 1, 0},
                {0, 1, 0}};
        CountingDistinctRowsInABinaryMatrix c =
                new CountingDistinctRowsInABinaryMatrix(arr, row, column);

        int rows = c.countDistinctRows();
        System.out.println(rows); // 3
    }
}