import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBetweenSourcePointAndOtherPoints {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    ShortestPathBetweenSourcePointAndOtherPoints(int numVertices) {
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

    void BFS(int source, int[] distance) {
        boolean[] visited = new boolean[this.numVertices];
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.offer(source);
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int v : list.get(poll)) {
                if (!visited[v]) {
                    distance[v] = distance[poll] + 1; // Add previous + 1
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        int V = 4;
        ShortestPathBetweenSourcePointAndOtherPoints g = new ShortestPathBetweenSourcePointAndOtherPoints(V);

        // 0 - 1
        //  \ / \
        //   2 - 3
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        // (Distance)
        // 0->1 : 1
        // 0->2 : 1
        // 0->3 : 2

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int source = 0;
        distance[source] = 0;
        g.BFS(source, distance);

        for (int dist : distance)
            System.out.print(dist + " ");
    }
}
