public class RemoveDuplicatesFromSortedArray {
    int removeDuplicatesFromSortedArray(int[] arr) {
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[size - 1])
                arr[size++] = arr[i];
        }
        return size;
    }
}

class Main {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
        int sortedArray[] = new int[]{10, 20, 20, 30, 30, 40};
        int size = sortedArray.length;
        for (int i = 0; i < size; i++)
            System.out.print(sortedArray[i] + " ");
        System.out.println();

        size = rdfsa.removeDuplicatesFromSortedArray(sortedArray);
        // 10 20 30 40
        for (int i = 0; i < size; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();

    }
}
