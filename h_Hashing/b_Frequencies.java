import java.util.HashMap;
import java.util.Map;

public class Frequencies {
    void printFrequencies(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 12, 13, 12, 13, 13, 18};
        Frequencies f = new Frequencies();
        f.printFrequencies(arr);
    }
}
