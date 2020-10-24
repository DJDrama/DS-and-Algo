public class LeftRotateByOne {
    void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for(int i=1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }

    void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LeftRotateByOne l = new LeftRotateByOne();
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("---- Before Rotation ----");
        l.printArray(arr);

        l.leftRotateByOne(arr);
        System.out.println("---- After Rotation ----");
        l.printArray(arr); // --> 2, 3, 4, 5, 1
    }
}
