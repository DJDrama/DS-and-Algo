import java.util.*;

class AdjListNode {
    int v, weight;

    AdjListNode(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

public class ShortestPathInDirectedAcyclicGraph {
    private int numVertices;
    private LinkedList<AdjListNode> adj[];

    ShortestPathInDirectedAcyclicGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adj = new LinkedList[numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int s, int e, int weight) {
        AdjListNode node = new AdjListNode(e, weight);
        adj[s].add(node);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;
        Iterator<AdjListNode> iterator = adj[v].iterator();
        while (iterator.hasNext()) {
            AdjListNode node = iterator.next();
            if (!visited[node.v]) {
                topologicalSortUtil(node.v, visited, stack);
            }
        }
        stack.push(v);
    }

    void shortestPath(int s) {
        Stack stack = new Stack();
        int[] dist = new int[this.numVertices];
        boolean[] visited = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while (!stack.isEmpty()) {
            int popped = (int) stack.pop();
            Iterator<AdjListNode> it;
            if (dist[popped] != Integer.MAX_VALUE) {
                it = adj[popped].iterator();
                while (it.hasNext()) {
                    AdjListNode i = it.next();
                    if (dist[i.v] > dist[popped] + i.weight)
                        dist[i.v] = dist[popped] + i.weight;
                }
            }
        }
        for (int i = 0; i < this.numVertices; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
    }


}

class Main {
    public static void main(String[] args) {
        int V = 6;
        ShortestPathInDirectedAcyclicGraph g = new ShortestPathInDirectedAcyclicGraph(V);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);
        g.shortestPath(0); // 0 2 3 6 1 5
    }
}
