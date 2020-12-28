public class UnionByRank {
    private int[] parent;

    UnionByRank(int[] p) {
        this.parent = p;
    }

    void initialize() {
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
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

        UnionByRank u = new UnionByRank(parent);

        // parent = {0, 1, 2, 3, 4}
        u.initialize();

        // union(0, 2)
        // xRep=0, yRep=2
        // parent[2]=0 --> {0, 1, 0, 3, 4}
        u.union(0, 2);

        // union(0, 4)
        // xRep=0, yRep=4
        // parent[4]=0 --> {0, 1, 0, 3, 0}
        u.union(0, 4);

        // find(4)
        // parent[4]!=4 --> find(0)
        // result = 0
        System.out.println(u.find(4)); // 0

        // find(3)
        // parent[3]=3
        // result = 3
        System.out.println(u.find(3)); // 3

    }
}
