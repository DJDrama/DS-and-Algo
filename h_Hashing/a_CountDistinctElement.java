import java.util.HashSet;

public class CountDistinctElement {
    int countDistinctElementSize(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr)
            set.add(num);
        return set.size();
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = new int[]{15, 12, 13, 12, 13, 13, 18};
        CountDistinctElement c = new CountDistinctElement();

        System.out.println("Size : " + c.countDistinctElementSize(arr));
    }
}
