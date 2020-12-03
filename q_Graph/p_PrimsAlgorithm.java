import java.util.*;

public class PrimsAlgorithm {
    private int v;

    PrimsAlgorithm(int v) {
        this.v = v;
    }

    // O(v^2) time complexity
    int primMinimumSpanningTree(int[][] graph) {
        int res = 0;
        int[] key = new int[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] mSet = new boolean[v];
        key[0] = 0;

        for (int count = 0; count < v; count++) {
            int u = -1;
            for (int i = 0; i < v; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u]))
                    u = i;
            }
            mSet[u] = true;
            res += key[u];

            for (int vertex = 0; vertex < v; vertex++) {
                if (graph[u][vertex] != 0 && !mSet[vertex])
                    key[vertex] = Math.min(key[vertex], graph[u][vertex]);
            }
        }
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        int vertices = 4;
        PrimsAlgorithm g = new PrimsAlgorithm(vertices);

        int[][] graph = new int[][]{
                {0, 5, 8, 0},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {0, 15, 20, 0}
        };

        System.out.println(g.primMinimumSpanningTree(graph));
    }
}
