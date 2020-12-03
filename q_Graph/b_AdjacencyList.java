import java.util.ArrayList;

public class AdjacencyList {
    int numVertices;
    ArrayList<ArrayList<Integer>> list;

    AdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        list = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            list.add(new ArrayList<>());
        }
    }

    void addEdge(int i, int j) {
        list.get(i).add(j);
        list.get(j).add(i);
    }

    void printGraph() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList(4);
        // 0 - 1
        //  \ /
        //   2 - 3
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        g.printGraph();
    }
}
