import java.util.Arrays;

class KruskalAlgorithm{
    static class Edge implements Comparable<Edge>{
        int src, dest, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static class Subset{
        int parent, rank;
    }
    int V, E;
    Edge[] edge;
    KruskalAlgorithm(int v, int e){
        V=v;
        E=e;
        edge = new Edge[e];
        for(int i=0; i<e; i++)
            edge[i] = new Edge();
    }

    int find(Subset[] subsets, int i){
        if(subsets[i].parent!=i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y){
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);
        if(subsets[xRoot].rank < subsets[yRoot].rank)
            subsets[xRoot].parent = yRoot;
        else if(subsets[xRoot].rank > subsets[yRoot].rank)
            subsets[yRoot].parent = xRoot;
        else{
            subsets[yRoot].parent=xRoot;
            subsets[xRoot].rank++;
        }
    }
    void kruskalMst(){
        int e=0;
        int i=0;
        Arrays.sort(edge);
        Subset[] subsets = new Subset[V];
        for(i=0; i<V; i++)
            subsets[i]=new Subset();

        for(int v=0; v<V; v++){
            subsets[v].parent=v;
            subsets[v].rank=0;
        }
        i=0;
        int res=0;
        while(e<V-1){
            Edge nextEdge = new Edge();
            nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if(x!=y){
                e++;
                union(subsets, x, y);
                res+=nextEdge.weight;
            }
        }

        System.out.println("Weight of MST is: " + res);
    }
}
class Main {
    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 7; // Number of edges in graph
        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 8;

        // add edge 0-3
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 3;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        //add egde 2-4
        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 12;

        // add edge 3-4
        graph.edge[6].src = 3;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = 15;

        graph.kruskalMst();
    }
}
