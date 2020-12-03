import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    DetectCycleInDirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        this.list = new ArrayList<>(numVertices);
        for (int i = 0; i < this.numVertices; i++) {
            this.list.add(new ArrayList<>());
        }
    }

    void addEdge(int s, int e) {
        list.get(s).add(e);
    }

    private boolean dfsRecursion(int source, boolean[] visited, boolean[] recSt) {
        visited[source] = true;
        recSt[source] = true;
        for (int v : list.get(source)) {
            if (!visited[v] && dfsRecursion(v, visited, recSt))
                return true;
            else if (recSt[v]) {
                return true;
            }
        }
        recSt[source] = false;
        return false;
    }

    // O(V+E) time complexity
    // O(V) space complexity
    boolean DFS() {
        boolean[] visited = new boolean[this.numVertices];
        boolean[] recSt = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                if (dfsRecursion(i, visited, recSt))
                    return true;
            }
        }
        return false;
    }

}

class Main {
    public static void main(String[] args) {
        int V = 6;
        DetectCycleInDirectedGraph g = new DetectCycleInDirectedGraph(V);

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //                ∧         |
        //                └---------┘  (Cycle)

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        // When reaches 5
        // visited = {t, t, t, t, t, t}
        // recst   = {f, f, t, t, t, t}
        System.out.println("Has Cycle? " + g.DFS()); // True
    }
}
