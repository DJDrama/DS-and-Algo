import java.util.Stack;

public class LargestRectangularArea {

    // Largest Rectangular Area
    // {6, 2, 5, 4, 1, 5, 6} -> 10(last 5, 6, 5*2=10)
    // {2, 5, 1} --> 5(second element 5 1*5=5)

    // O(n^2) time complexity
    // O(1) space complexity
    int getMaxAreaNaive(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= curr) {
                    curr += arr[i];
                } else {
                    break;
                }
            }

            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] >= curr) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    // O(n) time complexity
    // O(n) space complexity
    int getMaxAreaEfficient(int[] arr) {
        Stack<Integer> s = new Stack();
        int res = 0;
        int tp;
        int curr;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                tp = s.pop();
                curr = arr[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
                res = Math.max(curr, res);
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            tp = s.pop();
            curr = arr[tp] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(curr, res);
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        LargestRectangularArea l = new LargestRectangularArea();
        int[] arr = {6, 2, 5, 4, 1, 5, 6};
        // Naive (compare left, right)
        System.out.println(l.getMaxAreaNaive(arr));

        // Efficient (Using Stack)
        // {0}
        // i=1, 6>=2 --> tp = 0, curr = 6*1 = 6 {1}
        // i=2, {1, 2}
        // i=3, 5>=4 --> tp=2, curr = 5*(3-1-1) = 5
        // i=4, 2>=1 --> tp=1, curr = 2*4 = 8 {4}
        // i=5, {4, 5}
        // i=6, {4, 5, 6}
        //---- end loop ----
        // {4, 5, 6}
        // arr[tp] = 6 --> curr = 6*(7-5-1) = 6
        // {4, 5}
        // arr[tp] = 5 --> curr = 5*(7-4-1) = 10 (MAX AREA)
        // {4}
        // arr[tp] = 1 --> curr = 1*7 = 7
        System.out.println(l.getMaxAreaEfficient(arr));

    }
}