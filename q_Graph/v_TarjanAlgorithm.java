import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TarjanAlgorithm {
    private final LinkedList<Integer>[] adj;
    int time = 0;
    static final int NIL = -1;
    int V;

    TarjanAlgorithm(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void SCCUtil(int u, int[] low, int[] disc, boolean[] stackMember, Stack<Integer> st) {
        disc[u] = time;
        low[u] = time;
        time += 1;
        stackMember[u] = true;
        st.push(u);
        int n;
        for (Integer integer : adj[u]) {
            n = integer;
            if (disc[n] == -1) {
                SCCUtil(n, low, disc, stackMember, st);
                low[u] = Math.min(low[u], low[n]);
            } else if (stackMember[n]) {
                low[u] = Math.min(low[u], disc[n]);
            }
        }

        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = st.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            }
            System.out.println();
        }
    }

    void SCC() {
        int[] disc = new int[V];
        int[] low = new int[V];
        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
        }
        boolean[] stackMember = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                SCCUtil(i, low, disc, stackMember, st);
        }
    }
}

class Main {
    public static void main(String[] args) {
        TarjanAlgorithm g = new TarjanAlgorithm(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("SSC in the graph ");
        g.SCC();
    }
}
