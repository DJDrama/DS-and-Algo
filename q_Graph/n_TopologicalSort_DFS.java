import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort_DFS {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    TopologicalSort_DFS(int numVertices) {
        this.numVertices = numVertices;
        this.list = new ArrayList<>(numVertices);
        for (int i = 0; i < this.numVertices; i++) {
            this.list.add(new ArrayList<>());
        }
    }

    void addEdge(int s, int e) {
        list.get(s).add(e);
    }

    private void dfs(int source, Stack<Integer> stack, boolean[] visited) {
        visited[source] = true;
        for (int v : list.get(source)) {
            if (!visited[v]) {
                dfs(v, stack, visited);
            }
        }
        stack.push(source);
    }

    void topologicalSort() {
        boolean[] visited = new boolean[this.numVertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (!visited[i])
                dfs(i, stack, visited);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }


}

class Main {
    public static void main(String[] args) {
        int V = 5;
        TopologicalSort_DFS g = new TopologicalSort_DFS(V);

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

        g.topologicalSort(); // 1 4 0 2 3

    }
}
