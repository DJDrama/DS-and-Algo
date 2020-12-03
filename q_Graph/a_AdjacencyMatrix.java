import java.util.Arrays;

public class AdjacencyMatrix {
    private boolean[][] adjMatrix;
    private int numVertices;

    AdjacencyMatrix(int numVertices){
        this.numVertices=numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add Edges
    void addEdge(int i, int j){
        adjMatrix[i][j]=true;
        adjMatrix[j][i]=true;
    }

    // Remove Edges
    void removeEdge(int i, int j){
        adjMatrix[i][j]=false;
        adjMatrix[j][i]=false;
    }

    // Print matrix


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.numVertices; i++){
            sb.append(i+ ": ");
            for(boolean j: adjMatrix[i]){
                sb.append((j ? 1: 0) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
class Main{
    public static void main(String[] args){
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        // 0 - 1
        //  \ /
        //   2 - 3
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }
}
