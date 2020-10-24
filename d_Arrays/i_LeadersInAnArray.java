import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
    // Leaders in an array
    // 7, 10, 4, 3, 6, 5, 2 --> 10, 6, 5, 2
    // 10, 20, 30 --> 30
    // 30, 20, 10 --> 30, 20, 10

    List<Integer> leadersInAnArray(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int currentLeader = arr[n - 1];
        res.add(currentLeader);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > currentLeader) {
                currentLeader = arr[i];
                res.add(currentLeader);
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        LeadersInAnArray l = new LeadersInAnArray();
        int[] arr = {7, 10, 4, 3, 6, 5, 2};
        List<Integer> ans = l.leadersInAnArray(arr);
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " "); //10 6 5 2
        }
    }
}
