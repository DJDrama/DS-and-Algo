import java.util.Arrays;

public class MeetingMaximumGuests {
    // 0<=arr[], dep[] <=2359
    // arr[] = {900, 940}, dep[] = {1000, 1030}  --> 2 (9:40~10:00)
    // arr[] = {800, 700, 600, 500}, dep = {840, 820, 830, 530} --> 3 (8:00 ~ 8:20)
    // arr[] = {900, 940, 950, 1100, 1500, 1800}, dep = {910, 1200, 1120, 1130, 1900, 2000} --> 3 (11:00 ~ 11:20)
    int maxGuests(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1;
        int j = 0;
        int res = 1;
        int cur = 1;

        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                i++;
                cur++;
            } else {
                j++;
                cur--;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

}


class Main {
    public static void main(String[] args) {
        MeetingMaximumGuests m = new MeetingMaximumGuests();
        int[] arr = {800, 700, 600, 500};
        int[] dep = {840, 820, 830, 530};

        int max = m.maxGuests(arr, dep);
        System.out.println(max);
    }

}
