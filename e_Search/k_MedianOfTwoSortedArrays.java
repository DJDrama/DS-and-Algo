public class MedianOfTwoSortedArrays {
    //Median of Two Sorted Arrays
    // a1[] = {10, 20, 30, 40, 50}
    // a2[] = {5, 15, 25, 35, 45}
    // O(log(m+n)) time complexity
    double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int begin = 0;
        int end = n1;
        while (begin < end) {
            int i1 = (begin + end) / 2;
            int i2 = (n1 + n2 + 1) / 2 - i1;

            int min1 = (i1 == n1) ? Integer.MAX_VALUE : a[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : a[i1-1];

            int min2 = (i2 == n2) ? Integer.MAX_VALUE : b[i2];
            int max2 = (i1 == 0) ? Integer.MIN_VALUE : a[i2-1];

            if(max1 <= min2 && max2 <= min1){
                if((n1+n2)%2==0)
                    return ((double) Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                else
                    return (double) Math.max(max1, max2);
            }else if(max1 > min2)
                end = i1-1;
            else
                begin = i1+1;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        int a[] = {10, 20, 30, 40, 50};
        int b[] = {5, 15, 25, 35, 45};

        // begin=0, end=5
        // i1=2
        // i2=3
        // min1= 2!=5 so 30
        // max1= 2!=0 so 20
        // min2= 3!=5 so 35
        // max2= 2!=0 so 30
        // 20<=35 && 30<=30
        // 10%2==0 so (30+30)/2 = 30
        System.out.println(m.findMedianSortedArrays(a, b)); // 30

        a = new int[]{10, 20, 30};
        b = new int[]{5, 15, 25, 35, 45};

        // begin=0, end=3
        // i1=1, i2=3
        // min1 = 20
        // max1 = 10
        // min2 = 35
        // max2 = 25
        // 10<=35 && 25<=20 (FALSE)

        // begin = 2
        // i1=2, i2=2
        // min1=30
        // max1=20
        // min2=25
        // max2=15
        // 20<=25 && 15<=30
        // 8%2==0 so 20 + 25 /2 = 22.5
        System.out.println(m.findMedianSortedArrays(a, b)); // 22.5
    }
}
