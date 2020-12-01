import java.util.TreeSet;

public class BinarySearchTree_CeilOnLeftSideInAnArray {
    // Ceiling(smallest element that is greater or equal to given element) on left side
    // {2, 8, 30, 15, 25, 12} --> -1 -1 -1 30 30 15
    // {30, 20, 10} --> -1 30 20
    // {10, 20, 30} --> -1 -1 -1
    void printCeilingOnLeftSide(int[] arr) {
        if(arr.length==0) return;
        System.out.print("-1 ");
        TreeSet<Integer> s = new TreeSet<>();
        s.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(s.ceiling(arr[i])!=null)
                System.out.print(s.ceiling(arr[i])+ " ");
            else
                System.out.print("-1 ");
            s.add(arr[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        BinarySearchTree_CeilOnLeftSideInAnArray b = new BinarySearchTree_CeilOnLeftSideInAnArray();
        b.printCeilingOnLeftSide(arr);
    }
}
