import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_UndirectedGraph_SourceGiven {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    BFS_UndirectedGraph_SourceGiven(int numVertices) {
        this.numVertices = numVertices;
        this.list = new ArrayList<>(numVertices);
        for (int i = 0; i < this.numVertices; i++) {
            this.list.add(new ArrayList<>());
        }
    }

    void addEdge(int s, int e) {
        list.get(s).add(e);
        list.get(e).add(s);
    }

    // O(V+E) time complexity
    // O(V) space complexity
    void BFS(int source) {
        boolean[] visited = new boolean[this.numVertices];
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.offer(source);

        while (!q.isEmpty()) {
            int polled = q.poll();
            System.out.print(polled + " ");

            for (int vertex : list.get(polled)) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    q.offer(vertex);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int V = 5;
        BFS_UndirectedGraph_SourceGiven g = new BFS_UndirectedGraph_SourceGiven(V);
        // 0 - 1
        //  \ / \
        //   2 - 3
        //    \ /
        //     4
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);

        int startSource = 0;
        g.BFS(startSource); // 0 1 2 3 4
    }
}
