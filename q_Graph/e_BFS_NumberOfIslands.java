import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_NumberOfIslands {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    BFS_NumberOfIslands(int numVertices) {
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


    private void BFS(boolean[] visited, int source) {
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.offer(source);

        while (!q.isEmpty()) {
            int polled = q.poll();
            for (int vertex : list.get(polled)) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    q.offer(vertex);
                }
            }
        }
    }

    // O(V+E) time complexity
    // O(V) space complexity
    int BFSDisconnected() {
        int count = 0;
        boolean[] visited = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                BFS(visited, i);
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        int V = 7;
        BFS_NumberOfIslands g = new BFS_NumberOfIslands(V);
        // 0 - 1
        //  \   \
        //   2 - 3
        //              (DisConnected)
        //     4 - 5
        //      \ /
        //       6
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(4, 6);

        System.out.println("Number of islands : " + g.BFSDisconnected());
    }
}
