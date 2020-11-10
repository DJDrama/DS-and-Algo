public class SortAnArrayWithTwoTypesOfElements {
    // {-12, 10, -10, 15} --> {-12, -10, 10, 15}
    // O(n) time complexity, O(n) space complexity
    void naiveSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                temp[index++] = arr[i];
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] > 0)
                temp[index++] = arr[j];
        }

        for (int i = 0; i < temp.length; i++)
            arr[i] = temp[i];
    }

    // O(n) time complexity, O(1) space complexity
    void efficient(int[] arr) {
        // reference hoare's partitioning
        int i = -1;
        int n = arr.length;
        int j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] > 0);
            if (i >= j)
                return;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

class Main {
    public static void main(String[] args) {
        SortAnArrayWithTwoTypesOfElements s = new SortAnArrayWithTwoTypesOfElements();
        int[] arr = {-12, 10, -10, 15};
        s.naiveSort(arr);

        for (int num : arr)
            System.out.print(num + " ");

        System.out.println();

        arr = new int[]{-12, 10, -10, 15};
        s.efficient(arr);

        for (int num : arr)
            System.out.print(num + " ");


    }
}
