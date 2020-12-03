import java.util.*;

public class KosarajuAlgorithm {
    private int V;
    private LinkedList<Integer>[] adj;

    KosarajuAlgorithm(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    KosarajuAlgorithm getTranspose() {
        KosarajuAlgorithm g = new KosarajuAlgorithm(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    private void fillOrder(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }

    void printStronglyConnectedComponents() {
        Stack stack = new Stack();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);
        KosarajuAlgorithm gr = getTranspose();

        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = (int) stack.pop();
            if (!visited[v]) {
                gr.dfsUtil(v, visited);
                System.out.println();
            }
        }

    }
}

class Main {
    public static void main(String[] args) {
        int vertices = 5;
        KosarajuAlgorithm g = new KosarajuAlgorithm(vertices);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);


        g.printStronglyConnectedComponents();
    }
}
