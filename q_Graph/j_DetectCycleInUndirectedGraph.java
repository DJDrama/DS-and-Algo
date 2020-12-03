import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    DetectCycleInUndirectedGraph(int numVertices) {
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

    boolean dfsRecursion(int source, int parent, boolean[] visited) {
        visited[source] = true;
        for (int v : list.get(source)) {
            if (!visited[v]) {
                boolean res = dfsRecursion(v, source, visited);
                if (res)
                    return true;
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }

    boolean DFS() {
        boolean[] visited = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i]) {
                int parent = -1;
                boolean res = dfsRecursion(i, parent, visited);
                if (res)
                    return true;
            }
        }
        return false;
    }


}

class Main {
    public static void main(String[] args) {
        int V = 6;
        DetectCycleInUndirectedGraph g = new DetectCycleInUndirectedGraph(V);

        // 0 - 1
        //    / \
        //   2 - 3  <--(Cycle)
        //   |
        //   4 - 5
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        g.addEdge(2, 3);


        System.out.println("Has Cycle? " + g.DFS());
    }
}
