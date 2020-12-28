public class UnionByRank {
    private int[] parent;
    private int[] ranks;
    UnionByRank(int[] p, int[] r){
        this.parent = p;
        this.ranks = r;
    }
    void initialize(){
        for(int i=0; i<parent.length; i++)
            parent[i]=i;
    }
    int find(int x){
        if(parent[x]==x)
            return x;
        return find(parent[x]);
    }
    void union(int x, int y){
        int xRep=find(x);
        int yRep=find(y);
        if(xRep==yRep)
            return;
        if(ranks[xRep] < ranks[yRep])
            parent[xRep]=yRep;
        else if(ranks[yRep] < ranks[xRep])
            parent[yRep]=xRep;
        else{
            parent[yRep] = xRep;
            ranks[xRep]++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] parent = new int[n];
        int[] ranks = new int[n];

        UnionByRank u = new UnionByRank(parent, ranks);
        u.initialize();

        u.union(3, 4);
        u.union(2, 3);
        u.union(1, 2);
        u.union(0, 1);

        System.out.println(parent[3]); // 3
        System.out.println(ranks[3]); // 1


    }
}
