public class RepeatingElement {
    //Repeating Element
    //{1, 2, 3, 6, 3, 4, 5} --> 3
    //{3, 4, 5, 1, 2, 4, 4} --> 4
    // Array size >=2, only one element repeats,
    // all the elements from 1 to max(arr) are present.
    // 0<=max(arr)<=n-2

    //O(n) time complexity, O(1) space complexity
    int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[arr[0]];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}

class Main {
    public static void main(String[] args) {
        RepeatingElement r = new RepeatingElement();
        int[] arr = {1, 2, 3, 6, 3, 4, 5};

        // slow=1, fast=2
        // while(slow!=fast)
        // slow=2, fast=6,
        // slow=3, fast=4,
        // slow=6, fast=6 stop
        // fast=0
        // while(slow!=fast)
        // slow=5, fast=1,
        // slow=4, fast=2,
        // slow=3, fast=3
        // return 3
        System.out.println(r.findDuplicate(arr));

    }

}