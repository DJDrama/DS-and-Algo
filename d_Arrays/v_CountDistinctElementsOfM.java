import java.util.HashMap;
import java.util.HashSet;

public class CountDistinctElementsOfM {
    // O(n) time complexity, O(n) space complexity
    void printDistinctElementsOfM(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");
        for (int i = k; i < arr.length; i++) {
            if (map.get(arr[i - k]) == 1)
                map.remove(arr[i - k]);
            else
                map.put(arr[i - k], map.getOrDefault(arr[i - k], 0) - 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.print(map.size() + " ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        //count distinct elements m every window of
        // {1, 2, 1, 3, 4, 3, 3}, k=4 --> 3 4 3 2
        // {1, 2, 1, 3} , {2, 1, 3, 4}, {1, 3, 4, 3}, {3, 4, 3, 3} --> 3, 4, 3, 2
        CountDistinctElementsOfM d = new CountDistinctElementsOfM();
        int arr[] = {1, 2, 1, 3, 4, 3, 3};
        int k = 4;
        d.printDistinctElementsOfM(arr, k);
    }
}
