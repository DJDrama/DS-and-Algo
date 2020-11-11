import java.util.HashSet;

public class IntersectionOfTwoArrays {
    // {10, 15, 20, 15, 30, 30, 5}, {30, 5, 30, 80} --> 2 (30, 5)
    // {10, 20}, {20, 30} --> 1 (20)
    int getIntersectionCount(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet();
        for(int num: a)
            set.add(num);
        int res=0;
        for(int num: b){
            if(set.contains(num)){
                res++;
                set.remove(num);
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        int[] a = {10, 15, 20, 15, 30, 30, 5};
        int[] b = {30, 5, 30, 80};
        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        int count = i.getIntersectionCount(a, b);
        System.out.println("Count: " + count);
    }
}
