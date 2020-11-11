import java.util.HashSet;

public class ContiguousSubArrayWithZero {
    // {1, 4, 13, -3, -10, 5} // yes {13,-3,-10}
    // {-1, 4, -3, 5, 1} // yes {-1, 4, -3}
    // {3, 1, -2, 5, 6} // no
    // O(n) time complexity, O(n) space Complexity
    boolean hasSubArray(int[] arr) {
        HashSet<Integer> set = new HashSet();
        set.add(0);
        int prefixSum=0;
        for(int num: arr){
            prefixSum += num;
            if(set.contains(prefixSum))
                return true;
            set.add(prefixSum);
        }
        return false;
    }

}

class Main {
    public static void main(String[] args) {
        ContiguousSubArrayWithZero c = new ContiguousSubArrayWithZero();

        int[] arr = {1, 4, 13, -3, -10, 5};

        // Prefix Sum: {1, 5, 18, 15, 5, 10}
        // set contains 5 so true
        System.out.println(c.hasSubArray(arr));

        arr = new int[]{-1, 4, -3, 5, 1};
        // Prefix Sum: {-1, 3, 0, 5, 6}
        // set contains 0 so true
        System.out.println(c.hasSubArray(arr));
    }
}
