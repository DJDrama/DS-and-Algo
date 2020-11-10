public class CycleSort {
    // Cycle Sort
    // 1) Worst case O(n^2)
    // 2) Does minimum memory writes and can be useful for
    //    cases where memory write is costly
    // 3) In-place and not stable
    // 4) useful to naive questions like find
    //    minimum swaps required to sort an array.
    // Time Complexity : O(n2)
    // Worst Case : O(n2)
    // Average Case: O(n2)
    // Best Case : O(n2)
    // This sorting algorithm is best suited for situations where
    // memory write or swap operations are costly.
    int cycleSort(int[] arr) {
        int memoryWrites=0;

        for (int cs = 0; cs < arr.length - 1; cs++) {
            int item = arr[cs];

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int pos = cs;
            for (int j = cs + 1; j < arr.length; j++) {
                if (arr[j] < item)
                    pos++;
            }

            // If item is already in correct position
            if (pos == cs)
                continue;

            // ignore all duplicate elements
            while (item == arr[pos])
                pos += 1;

            //swap
            // put the item to it's right position
            if (pos != cs) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                memoryWrites++;
            }

            // Rotate rest of the cycle
            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < arr.length; i++) {
                    if (arr[i] < item)
                        pos++;
                }

                // ignore all duplicate elements
                while (item == arr[pos])
                    pos += 1;

                //swap
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    memoryWrites++;
                }
            }
        }
        return memoryWrites;
    }
}


class Main {
    public static void main(String[] args) {
        CycleSort s = new CycleSort();
        int[] arr = {20, 40, 50, 10, 10, 30};

        int swaps = s.cycleSort(arr);
        System.out.println(swaps);

        for (int num : arr)
            System.out.print(num + " ");
    }

}
