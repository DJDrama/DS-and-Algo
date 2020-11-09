public class PairOfSum {
    // Given an SORTED array and a number x,
    // we need to find if there is a pair in the array with num equals to x
    // {2, 5, 8, 12, 30}, x =17
    // YES (5, 12)
    boolean hasPairOfSum(int[] arr, int sum) {
        int l=0;
        int r=arr.length-1;
        while(l<r){
            if(arr[l]+arr[r] == sum)
                return true;
            else if(arr[l] + arr[r] > sum)
                r--;
            else
                l++;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        PairOfSum p = new PairOfSum();
        int[] arr = {2, 5, 8, 12, 30};
        int sum = 42;

        boolean hasPair = p.hasPairOfSum(arr, sum);
        System.out.println(hasPair);
    }
}