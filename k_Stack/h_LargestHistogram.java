import java.util.Stack;

public class LargestHistogram {
    //Largest Rectangle with all 1s
    //{{0, 1, 1, 0}
    // {1, 1, 1, 1}
    // {1, 1, 1, 1} --> 8
    // {1, 1, 0, 0}}

    //{{0, 1, 1}
    // {1, 1, 1}
    // {0, 1, 1}} --> 6

    //{{0, 0}
    // {0, 0}} --> 0

    //{{0, 0}
    // {0, 1}} --> 1

    // {1, 1, 1} --> 3

    // O(r*c) time complexity, O(c) aux space
    int getMaxRectangle(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int res = getLargestHistogram(arr[0], r, c);
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1)
                    arr[i][j] += arr[i - 1][j];
            }
            res = Math.max(res, getLargestHistogram(arr[i], r, c));
        }
        return res;
    }

    private int getLargestHistogram(int[] arr, int row, int col) {
        Stack<Integer> stack = new Stack();
        int topVal, maxArea = 0, area = 0;
        int i = 0;
        while (i < col) {
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            } else {
                topVal = arr[stack.pop()];
                area = topVal * i;

                if (!stack.isEmpty())
                    area = topVal * (i - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!stack.isEmpty()) {
            topVal = arr[stack.pop()];
            area = topVal * i;
            if (!stack.isEmpty())
                area = topVal * (i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

class Main {
    public static void main(String[] args) {
        LargestHistogram l = new LargestHistogram();
        int[][] arr =
                {{0, 1, 1, 0},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0}};
        System.out.println(l.getMaxRectangle(arr)); //8
    }
}