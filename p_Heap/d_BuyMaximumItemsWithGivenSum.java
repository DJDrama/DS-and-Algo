import java.util.Arrays;
import java.util.PriorityQueue;

public class BuyMaximumItemsWithGivenSum {
    // Buy Maximum Items with Given Sum
    // {1, 12, 5, 111, 200}, sum = 10 --> 2 items (1, 5)
    // {20, 10, 5, 30, 100}, sum=35 --> 3 items(20, 10, 5)

    // O(nlogn) time complexity (sorting)
    // O(1) space complexity
    int getItemCountWithGivenSumNaive(int[] arr, int sum) {
        Arrays.sort(arr);
        int res = 0;
        for (int j : arr) {
            if (j <= sum) {
                sum -= j;
                res++;
            } else
                break;
        }
        return res;
    }

    // O(nlogn) time complexity
    // O(n) space complexity
    int getItemCountWithGivenSumEfficient(int[] arr, int sum){
        int res=0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num: arr)
            q.offer(num);

        for(int i=0; i<arr.length; i++) {
            if(q.peek() <=sum){
                sum-=q.poll();
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        BuyMaximumItemsWithGivenSum b = new BuyMaximumItemsWithGivenSum();
        int[] arr = {1, 12, 5, 111, 200};
        int sum = 10;

        System.out.println("Naive : " + b.getItemCountWithGivenSumNaive(arr, sum));
        System.out.println("Efficient : " + b.getItemCountWithGivenSumEfficient(arr, sum));


    }
}