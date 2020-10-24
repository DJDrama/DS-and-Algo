public class MaximumDifferenceProblem {
    //Maximum Difference
    // arr[j] - arr[i] such that j > i
    // 2, 3, 10, 6, 4, 8, 1 --> 8 ( 10 - 2 )

    //Naive Solution
    //O(n^2) time complexity, O(1) space complexity
    int maximumDifferenceNaive(int[] arr){
        int res=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                res = Math.max(arr[j]-arr[i], res);
            }
        }
        return res;
    }

    //Efficient Solution
    // O(n) time complexity, O(1) space complexity
    int maximumDifferenceEfficient(int[] arr){
        int res=0;
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            res = Math.max(res, arr[i]-min);
            min = Math.min(min, arr[i]);
        }
        return res;
    }


}

class Main {
    public static void main(String[] args) {
        MaximumDifferenceProblem m = new MaximumDifferenceProblem();
        int arr[] = new int[]{2, 3, 10, 6, 4, 8, 1};
        int max = m.maximumDifferenceNaive(arr);
        System.out.println(max); // 8

        arr = new int[]{2, 1, 5, 3, 10, 6, 4, 8, 1};
        max = m.maximumDifferenceEfficient(arr); // 9
        System.out.println(max);
    }
}
