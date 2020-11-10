public class SortAnArrayWithThreeTypesOfElements {
    // ex) sort an array of 0s, 1s and 2s {0, 1, 0, 2, 1, 2} --> {0, 0, 1, 1, 2, 2}
    // ex) three way partitioning when multiple occurrence of a pivot may exist
    // ex) partitioning around a range
    void dutchNationalFlagAlgorithm(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (mid <= r) {
            switch (arr[mid]) {
                case 0 -> {
                    swap(arr, l, mid);
                    l++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    swap(arr, mid, r);
                    r--;
                }
            }
        }
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class Main {
    public static void main(String[] args) {
        SortAnArrayWithThreeTypesOfElements s = new SortAnArrayWithThreeTypesOfElements();
        int[] arr = {0, 1, 0, 2, 1, 2};

        // l=0, r=5, mid=0;
        // arr[0] = 0 --> swap(0, 0), l=1, mid=1
        // arr[1] = 1 --> mid=2
        // arr[2] = 0 --> swap(1, 2), l=2, mid=3
        // {0, 0, 1, 2, 1, 2}
        // arr[3] = 2 --> swap(3, 5), r=4
        // {0, 0, 1, 2, 1, 2}
        // arr[3] = 2 --> swap(3, 4), r=3
        // {0, 0, 1, 1, 2, 2}
        // arr[3] = 1 --> mid=4
        // mid>hi end loop
        s.dutchNationalFlagAlgorithm(arr);

        for (int num : arr)
            System.out.print(num + " ");
    }
}
