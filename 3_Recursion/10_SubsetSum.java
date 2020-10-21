public class SubsetSum {
    int subsetSumCount(int[] arr, int sum, int n) {
        if (n == 0)
            return sum == 0 ? 1 : 0;
        return subsetSumCount(arr, sum, n-1)
                + subsetSumCount(arr, sum-arr[n-1], n-1);
    }
}

//{10, 5, 2, 3, 6} sum=8 --> 2 subsets {5, 3}, {2, 6}
//{1, 2, 3} sum=4 --> 1 subset
//{10, 20, 15} sum=37 --> 0 subset
//{10, 20, 15} sum=0 --> 1 subset (Empty Set)
// 2^n + (2^n-1) --> o(2^n)

class Main {
    public static void main(String[] args) {
        SubsetSum s = new SubsetSum();

        int[] arr = {10, 5, 2, 3, 6};
        int sum = 8;
        int subsets = s.subsetSumCount(arr, sum, arr.length);
        System.out.println("Subsets count: " + subsets);
    }
}