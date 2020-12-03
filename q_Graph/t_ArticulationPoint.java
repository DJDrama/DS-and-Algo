import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ArticulationPoint {
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;
    int V;

    ArticulationPoint(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void APUtil(int i, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
        int children = 0;
        visited[i] = true;
        disc[i] = low[i] = ++time;
        for (int n : adj[i]) {
            if (!visited[n]) {
                children++;
                parent[n] = i;
                APUtil(n, visited, disc, low, parent, ap);
                low[i] = Math.min(low[i], low[n]);
                if (parent[i] == NIL && children > 1)
                    ap[i] = true;
                if (parent[i] != NIL && low[n] >= disc[n])
                    ap[i] = true;
            } else if (n != parent[i])
                low[i] = Math.min(low[i], disc[n]);
        }

    }

    void AP() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);
        for (int i = 0; i < V; i++)
            if (ap[i])
                System.out.print(i + " ");
    }
}

class Main {
    public static void main(String[] args) {
        ArticulationPoint g = new ArticulationPoint(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.AP(); // 0 3
    }
}
