import java.util.Arrays;

public class MinimumCoins {
    // {10, 5, 2, 1}, amount=52
    // max : 10*5 + 1*2 = 6 coins

    // O(nlogn) time complexity
    // O(1) space complexity
    int minCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                int c = (int) Math.floor(amount / coins[i]);
                res += c;
                amount -= coins[i] * c;
            }
            if(amount==0)
                break;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        int[] coins = {10, 5, 2, 1};
        int amount = 52;

        MinimumCoins mc = new MinimumCoins();
        System.out.println("Number of Coins : " + mc.minCoins(coins, amount)); // 6
    }
}
