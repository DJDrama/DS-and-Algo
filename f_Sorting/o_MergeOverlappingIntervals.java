import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    // Merge Overlapping Intervals
    // {{1, 3}, {2, 4}, {5, 7}, {6, 8}} --> {{1, 4}, {5, 8}}
    // {{7, 9}, {6, 10}, {4, 5}, {1, 3}, {2, 4}} --> {{1, 5}, {6, 10}}
    // Sort by start time in increasing order
    int mergeIntervals(Interval arr[]) {
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res].end >= arr[i].start) {
                arr[res].end = Math.max(arr[res].end, arr[i].end);
                arr[res].start = Math.min(arr[res].start, arr[i].start);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }
        return res;
    }
}

class Interval {
    int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Main {
    public static void main(String[] args) {
        MergeOverlappingIntervals m = new MergeOverlappingIntervals();
        Interval[] arr = {
                new Interval(1, 3),
                new Interval(2, 4),
                new Interval(5, 7),
                new Interval(6, 8)};
        int size = m.mergeIntervals(arr);

        for(int i=0; i<=size; i++){
            System.out.println(arr[i].start+ " " + arr[i].end);
        }
    }
}
