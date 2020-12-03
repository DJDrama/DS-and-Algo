import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUsingTopologicalSorting {
    private int numVertices;
    private ArrayList<ArrayList<Integer>> list;

    DetectCycleUsingTopologicalSorting(int numVertices) {
        this.numVertices = numVertices;
        this.list = new ArrayList<>(numVertices);
        for (int i = 0; i < this.numVertices; i++) {
            this.list.add(new ArrayList<>());
        }
    }

    void addEdge(int s, int e) {
        list.get(s).add(e);
    }

    void topologicalSort(){
        int[] inDegree = new int[this.numVertices];
        for(int i=0; i<this.numVertices; i++){
            for(int x: list.get(i)){
                inDegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length;i++){
            if(inDegree[i]==0)
                q.offer(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int polled = q.poll();
            for(int v: list.get(polled)){
                if(--inDegree[v]==0)
                    q.offer(v);
            }
            count++;
        }
        if(count!=this.numVertices)
            System.out.println("Has Cycle");
        else
            System.out.println("No Cycle");
    }


}

class Main {
    public static void main(String[] args) {
        int V = 6;
        DetectCycleUsingTopologicalSorting g = new DetectCycleUsingTopologicalSorting(V);

        // 0 -> 1 -> 2 -> 3 -> 4 -> 5
        //                ∧         |
        //                └---------┘  (Cycle)
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        g.topologicalSort(); // Has Cycle

    }
}
