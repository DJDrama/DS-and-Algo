import java.util.HashSet;

public class UnionOfTwoSortedArrays {
    // Union of two unsorted arrays
    // {15, 20, 5, 15}, {15, 15, 15, 20, 10} --> 4 {15, 20, 10, 5}
    // O(m+n) time complexity, O(n) space complexity
    int getUnionSize(int[] a, int[] b){
        HashSet<Integer> set = new HashSet<>();
        for(int num: a)
            set.add(num);
        for(int num: b)
            set.add(num);
        return set.size();
    }

}

class Main {
    public static void main(String[] args) {
        UnionOfTwoSortedArrays u = new UnionOfTwoSortedArrays();
        int[] a = new int[]{15, 20, 5, 15};
        int[] b = new int[]{15, 15, 15, 20, 10};
        System.out.println(u.getUnionSize(a, b));
    }
}
