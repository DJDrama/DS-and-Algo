public class MajorityElement {
    // Majority element is an element that appears more than n/2 times in an array of size n.
    // In this video, two methods to find majority element in an array are discussed.
    // O(n) time complexity, O(1) space complexity
    int getMajorityIndex(int[] arr) {
        int res = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i])
                count++;
            else
                count--;
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i])
                count++;
        }
        if (count > arr.length / 2) {
            return res;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int arr[] = {8, 8, 6, 6, 6, 4, 6};
        int majorityElementIndex = m.getMajorityIndex(arr);
        System.out.println(majorityElementIndex);
    }

}