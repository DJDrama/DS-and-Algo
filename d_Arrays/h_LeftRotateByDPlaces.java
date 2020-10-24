public class LeftRotateByDPlaces {
    void leftRotateByDPlaces(int[] arr, int d) {
        //O(n) time, O(1) space
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    void reverseArray(int[] arr, int from, int until) {
        int l = from, r = until;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LeftRotateByDPlaces l = new LeftRotateByDPlaces();
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("---- Before Rotation ----");
        l.printArray(arr);

        l.leftRotateByDPlaces(arr, 2);
        System.out.println("---- After Rotation ----");
        l.printArray(arr); // --> 3, 4, 5, 1, 2

        // How does this work?
        // 1, 2, 3, 4, 5 and d=2
        // 1) reverse array from 0 to d-1
        // {2, 1, 3, 4, 5}
        // 2) reverse array from d to array.length-1
        // {2, 1, 5, 4, 3}
        // 3) reverse whole array
        // {3, 4, 5, 1, 2}
    }
}
