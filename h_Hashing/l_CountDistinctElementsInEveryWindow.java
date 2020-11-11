import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    //Count Distinct Elements in Every Window
    // {10, 20, 20, 10, 30, 40, 10}, k=4(window) --> 2 3 4 3
    // {10, 10, 10, 10}, k=3 --> 1 1
    // {10, 20, 30, 40}, k=3 --> 3 3
    // O(n) time complexity, O(n) space complexity
    void printDistinctElementCount(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        System.out.print(map.size() + " ");

        for (int i = 4; i < arr.length; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0)
                map.remove(arr[i - k]);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            System.out.print(map.size()+ " ");
        }
    }

}

class Main {
    public static void main(String[] args) {
        CountDistinctElementsInEveryWindow c = new CountDistinctElementsInEveryWindow();
        int a[] = {10, 20, 20, 10, 30, 40, 10};
        int k = 4; //window
        c.printDistinctElementCount(a, k);

    }
}
