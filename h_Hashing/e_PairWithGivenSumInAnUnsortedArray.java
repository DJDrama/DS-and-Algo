import java.util.HashSet;

public class PairWithGivenSumInAnUnsortedArray {
    // pair with given sum in an unsorted array
    // {3, 2, 8, 15, -8}
    // sum=17(2, 15) // yes
    // sum=120 // No
    boolean hasPair(int[] arr, int sum){
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr){
            if(set.contains(sum-num))
                return true;
            set.add(num);
        }
        return false;
    }

}

class Main {
    public static void main(String[] args) {
        PairWithGivenSumInAnUnsortedArray u = new PairWithGivenSumInAnUnsortedArray();
        int[] a = new int[]{3, 2, 8, 15, -8};
        int sum=17;

        System.out.println(u.hasPair(a, sum));

        sum=12;
        System.out.println(u.hasPair(a, sum));

    }
}
