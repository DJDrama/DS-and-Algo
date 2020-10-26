public class MajorityElement {
    // O(n^2) time complexity
    // O(1) space complexity
    int getMajorityElementNaive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > arr.length / 2)
                return i;
        }
        return -1;
    }

    // O(n) time complexity, O(1) space complexity
    int getMajorityElementEfficient(int[] arr) {
        int current = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[current] == arr[i])
                count++;
            else
                count--;
            if (count == 0) {
                current = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[current] == arr[i])
                count++;
        }
        if (count <= arr.length / 2)
            return -1;
        return current;
    }
}

class Main {
    public static void main(String[] args) {
        // Majority Element
        // Given an array of size n, find the majority element.
        // The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        // {8, 3, 4, 8, 8} --> 0 or 3 or 4
        // {3, 7, 4, 7, 7, 5} --> no majority (-1)
        // {20,30, 40, 50, 50, 50, 50} --> 3 or 4 or 5 or 6
        MajorityElement m = new MajorityElement();
        int arr[] = {8, 7, 6, 8, 6, 6, 6, 6};
        int index = m.getMajorityElementNaive(arr);
        if (index < 0)
            System.out.println("No Majority Element");
        else
            System.out.println("Index : " + index + " Element : " + arr[index]);

        arr = new int[]{3, 7, 4, 7, 7, 5};
        // 1) 3 -> 7 -> 4 -> 7, 7 count=2, current = 4
        // 2) 7's count will be 3
        // 3) 3<=3 so return -1
        index = m.getMajorityElementEfficient(arr);
        if (index < 0)
            System.out.println("No Majority Element");
        else
            System.out.println("Index : " + index + " Element : " + arr[index]);


    }
}
