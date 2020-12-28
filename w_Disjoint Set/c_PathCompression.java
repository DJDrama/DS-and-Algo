public class PathCompression {
    private int[] parent;

    PathCompression(int[] p) {
        this.parent = p;
    }

    void initialize() {
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int xRep = find(x);
        int yRep = find(y);
        if (xRep == yRep)
            return;
        parent[yRep] = xRep;
    }
}

class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] parent = new int[n];
        PathCompression p = new PathCompression(parent);


        p.initialize();

        p.union(0, 2);
        p.union(0, 4);

        System.out.println(p.find(4)); // 0
        System.out.println(p.find(3)); // 3
    }
}
