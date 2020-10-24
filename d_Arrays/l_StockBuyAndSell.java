public class StockBuyAndSell {
    // Stock Buy And Sell
    // 1, 5, 3, 8, 12 --> 13 (1-5) + (3-12)
    // 30, 20, 10 --> 0
    // 10, 20, 30 --> 20
    // 1, 5, 3, 1, 2, 8 --> 11 (1-5) + (1-8)
    // O(n) time complexity, O(1) space complexity
    int maxProfit(int[] arr){
        int res=0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>arr[i-1]){
                res+=arr[i]-arr[i-1];
            }
        }
        return res;
    }

}

class Main {
    public static void main(String[] args) {
        StockBuyAndSell s = new StockBuyAndSell();
        int[] arr = new int[]{1, 5, 3, 8, 12};
        System.out.println(s.maxProfit(arr));
    }
}
