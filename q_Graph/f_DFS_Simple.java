import java.util.ArrayList;

public class DFS_Simple {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    DFS_Simple(int numVertices) {
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

    void DFS(int source) {
        boolean[] visited = new boolean[this.numVertices];
        dfsRecursion(source, visited);
    }

    private void dfsRecursion(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int vertex : list.get(source)) {
            if (!visited[vertex]) {
                dfsRecursion(vertex, visited);
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        int V = 5;
        DFS_Simple g = new DFS_Simple(V);

        // 0 - 1 - 4
        //  \   \ /
        //   2 - 3
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 4);

        int source = 0;
        g.DFS(source);  // 0 1 3 2 4
    }
}
