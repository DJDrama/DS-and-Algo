public class IsArraySorted {
    // O(n) time, O(1) space
    boolean isArraySortedAscending(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        IsArraySorted i = new IsArraySorted();
        int[] arr = new int[]{5, 20, 23, 30, 40};

        // 5 < 20 < 23 < 30 < 40
        boolean isSorted = i.isArraySortedAscending(arr);
        System.out.println(isSorted);
    }
}