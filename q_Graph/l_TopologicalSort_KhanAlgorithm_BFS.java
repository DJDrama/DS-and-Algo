import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_KhanAlgorithm {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    TopologicalSort_KhanAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        this.list = new ArrayList<>(numVertices);
        for (int i = 0; i < this.numVertices; i++) {
            this.list.add(new ArrayList<>());
        }
    }

    void addEdge(int s, int e) {
        list.get(s).add(e);
    }

    void topologicalSort() {
        int[] inDegree = new int[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            for (int x : list.get(i))
                inDegree[x]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int polled = q.poll();
            System.out.print(polled + " ");

            for (int v : list.get(polled)) {
                if (--inDegree[v] == 0)
                    q.offer(v);
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        int V = 5;
        TopologicalSort_KhanAlgorithm g = new TopologicalSort_KhanAlgorithm(V);

        //   ┌-------> 3 <┐
        //   |         ∧  |
        //   0 -> 2 ---┘  |
        //   ┌--> 4       |
        //   1 -----------┘
        //
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);

        g.topologicalSort(); // 0 1 2 4 3
    }
}
