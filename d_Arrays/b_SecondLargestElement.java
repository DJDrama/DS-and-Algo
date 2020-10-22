public class SecondLargestElement {
    int getSecondLargestElementIndex(int[] arr) {
        int res = -1;
        int largest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                //knowing that the elements are not same
                res = largest;
                largest = i;
                //when element is not same and current element is not the maximum value
            } else if (arr[i] != arr[largest]) {
                // compare current value with arr[res] which will be the second largest
                if (res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return res;
    }
}


class Main {
    public static void main(String[] args) {
        SecondLargestElement s = new SecondLargestElement();

        int[] arr = {1, 5, 2, 7, 6, 5};
        int secondLargestIndex = s.getSecondLargestElementIndex(arr);
        System.out.println(secondLargestIndex + " " + arr[secondLargestIndex]); // 4 6

        arr = new int[]{1, 1, 1};
        secondLargestIndex = s.getSecondLargestElementIndex(arr);
        System.out.println(secondLargestIndex ); // -1

    }
}