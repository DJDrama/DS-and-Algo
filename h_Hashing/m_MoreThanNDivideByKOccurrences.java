import java.util.HashMap;
import java.util.Map;

public class MoreThanNDivideByKOccurrences {
    // More than n/k Occurrences
    // {30, 10, 20, 20, 10, 20, 30, 30}, k=4 --> 20 30  (n/k == 2)
    // {30, 10, 20, 30, 30, 40, 30, 40, 30}, k=2 --> 30 (n/k==4.5)
    void printMoreOccurrences(int arr[], int k) {
        int nk = arr.length / k;
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nk)
                System.out.println(entry.getKey());
        }
    }
}

class Main {
    public static void main(String[] args) {
        MoreThanNDivideByKOccurrences c = new MoreThanNDivideByKOccurrences();
        int a[] = {30, 10, 20, 20, 10, 20, 30, 30};
        int k = 4;
        c.printMoreOccurrences(a, k); // 20 30

        a = new int[]{30, 10, 20, 30, 30, 40, 30, 40, 30};
        k=2;
        c.printMoreOccurrences(a, k);
    }
}
