public class NQueenProblem {
    private int n;
    private int[][] board;

    NQueenProblem(int n, int[][] board) {
        this.n = n;
        this.board = board;
    }

    private boolean solveRec(int col) {
        if (col == n)
            return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveRec(col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        int i, j;
        /* Check this row on left side */
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }
        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    void solve() {
        if (!solveRec(0)) {
            return;
        }
        printSolution();
    }

    private void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        int N = 4;
        int[][] board = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        NQueenProblem n = new NQueenProblem(N, board);
        n.solve();
    }
}
