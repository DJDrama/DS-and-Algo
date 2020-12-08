public class RatInAMaze {
    /**
     * Rat in a maze
     * only two moves allowed(down and right)
     * cheese = bottom right(last one)
     * int maze[][] = { { 1, 0, 0, 0 },
     * { 1, 1, 0, 1 },
     * { 0, 1, 0, 0 },
     * { 1, 1, 1, 1 } };
     * return true if has path, false if has no path
     */
    boolean solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] res = new int[n][n];
        if (!solveMazeRec(maze, 0, 0, res)) {
            System.out.println("No Solution!");
            return false;
        }
        printSolution(res);
        return true;
    }

    private boolean solveMazeRec(int[][] maze, int x, int y, int[][] res) {
        if (x == maze.length - 1 && y == maze.length - 1) {
            res[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            res[x][y] = 1;
            if (solveMazeRec(maze, x + 1, y, res)) {
                return true;
            }
            if (solveMazeRec(maze, x, y + 1, res)) {
                return true;
            }
            res[x][y] = 0;
        }
        return false;
    }

    private boolean isSafe(int[][] maze, int x, int y) {
        return x < maze.length && y < maze.length && maze[x][y] == 1;
    }

    private void printSolution(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[i].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        RatInAMaze r = new RatInAMaze();
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        /** output
         * 1 0 0 0
         * 1 1 0 0
         * 0 1 0 0
         * 0 1 1 1
         * **/
        r.solveMaze(maze);
    }
}
