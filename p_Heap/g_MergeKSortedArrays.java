import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {
    int val, aPos, vPos;
    Triplet(int v, int ap, int vp) {
        this.val = v;
        this.aPos = ap;
        this.vPos = vp;
    }
    @Override
    public int compareTo(Triplet o) {
        if (this.val <= o.val) return -1;
        else return 1;
    }
}

public class MergeKSortedArrays {
    // Merge k sorted arrays
    // {{10, 20, 30}, {5, 15}, {1, 9, 11, 18}} --> {1, 5, 9, 10, 11, 15, 18, 20, 30}
    // {{5, 20, 30}, {1, 2}} --> {1, 2, 5, 20, 30}
    List<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Triplet> q = new PriorityQueue<>();

        for(int i=0; i<arr.size(); i++) //put zero index elements
            q.offer(new Triplet(arr.get(i).get(0), i, 0));

        while(!q.isEmpty()){
            Triplet curr = q.poll();
            res.add(curr.val);
            int ap = curr.aPos;
            int vp = curr.vPos;
            if(vp+1 < arr.get(ap).size()){
                int value = arr.get(ap).get(vp+1);
                q.offer(new Triplet(value, ap, vp+1));
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        MergeKSortedArrays m = new MergeKSortedArrays();
        ArrayList<ArrayList<Integer> > arr= new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);

        List<Integer> ans = m.mergeKSortedArrays(arr);
        for (int x : ans) // 1 5 9 10 11 15 18 20 30
            System.out.print(x + " ");
    }
}