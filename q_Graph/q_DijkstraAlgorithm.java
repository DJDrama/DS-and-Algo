import java.util.*;

public class DijkstraAlgorithm {
    private int v;

    DijkstraAlgorithm(int v) {
        this.v = v;
    }

    int[] dijkstra(int[][] graph, int source) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        boolean[] fin = new boolean[v];
        
        for (int count = 0; count < v - 1; count++) {
            int u = -1;
            for (int i = 0; i < v; i++)
                if (!fin[i] && (u == -1 || dist[i] < dist[u]))
                    u = i;

            fin[u] = true;

            for(int v=0; v<this.v; v++){
                if(graph[u][v]!=0 && !fin[v])
                    dist[v] = Math.min(dist[v], dist[u]+graph[u][v]);
            }
        }
        return dist;
    }

}

class Main {
    public static void main(String[] args) {
        int vertices = 4;
        DijkstraAlgorithm g = new DijkstraAlgorithm(vertices);

        int[][] graph = new int[][]{
                {0, 50, 100, 0},
                {50, 0, 30, 200},
                {100, 30, 0, 20},
                {0, 200, 20, 0}
        };

        for(int x: g.dijkstra(graph, 0))
            System.out.print(x+ " ");
    }
}
