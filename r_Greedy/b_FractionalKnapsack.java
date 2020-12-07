import java.util.Arrays;

public class FractionalKnapsack {
    // Items as (value, weight) pairs
    // arr[] = {{60, 10}, {100, 20}, {120, 30}}
    // Knapsack Capacity, W = 50;
    // Output : 240 (maximum possible value)
    // 60 + 100 + 80 = 240
    int fracKnapSack(Item[] arr, int W) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].weight <= W) {
                res += arr[i].value;
                W -= arr[i].weight;
            } else {
                res += arr[i].value * ((double) W / arr[i].weight);
                break;
            }
        }
        return res;
    }
}

class Item implements Comparable<Item> {
    int weight, value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Item o) {
        return this.weight * o.value - this.value * o.weight;
        // weight/value <= o.weight/o.value
        // ex) 60, 10 --> weight/value is 0.6
        // ex) 40, 40 --> 1
        // ex) 20, 100 --> 0.2
        // ex) 30, 120 --> 0.25
        // sorted --> (20, 100), (30, 120), (60, 10), (40, 40)
    }
}

class Main {
    public static void main(String[] args) {
        Item[] arr = {new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)};
        int W = 50;
        FractionalKnapsack f = new FractionalKnapsack();
        System.out.println(f.fracKnapSack(arr, W)); // 240
    }
}
