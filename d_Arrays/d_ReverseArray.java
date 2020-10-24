public class ReverseArray {
    // O(n/2) -> O(n) time complexity
    // O(1) space complexity
    void reverseArray(int[] arr){
        int l=0, r=arr.length-1;
        while(l<r){
            int temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}


class Main {
    public static void main(String[] args) {
        ReverseArray ra = new ReverseArray();

        int[] arr = new int[]{5, 20, 13, 30, 40};

        ra.reverseArray(arr);
        for(int i: arr){
            System.out.print(i + " " ); //{40, 30, 13, 20, 5}
        }
    }
}