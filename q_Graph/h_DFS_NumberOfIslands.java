import java.util.ArrayList;

public class DFS_NumberOfIslands {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    DFS_NumberOfIslands(int numVertices) {
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
        for (int v : list.get(source)) {
            if (!visited[v]) {
                dfsRecursion(v, visited);
            }
        }
    }

    int DFS() {
        int count=0;
        boolean[] visited = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                count++;
                dfsRecursion(i, visited);
            }
        }
        return count;
    }

}

class Main {
    public static void main(String[] args) {
        int V = 5;
        DFS_NumberOfIslands g = new DFS_NumberOfIslands(V);

        // 0 - 1
        //  \ /
        //   2    3 - 4    (DisConnected)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        System.out.println("Number of islands : " + g.DFS()); // 2
    }
}
