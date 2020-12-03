import java.util.ArrayList;

public class DFS_DisconnectedGraph {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    DFS_DisconnectedGraph(int numVertices) {
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

    void dfsRecursion(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int v : list.get(source)) {
            if (!visited[v]) {
                dfsRecursion(v, visited);
            }
        }
    }

    void DFS() {
        boolean[] visited = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                dfsRecursion(i, visited);
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        int V = 5;
        DFS_DisconnectedGraph g = new DFS_DisconnectedGraph(V);

        // 0 - 1
        //  \ /
        //   2    3 - 4    (DisConnected)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        g.DFS(); // 0 1 2 3 4
    }
}
