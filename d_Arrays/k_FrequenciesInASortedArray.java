public class FrequenciesInASortedArray {
    //Frequencies in a sorted array
    // 10, 10, 10, 25, 30, 30 -> 10:3, 25:1, 30:2
    // 10, 10, 10, 10 -> 10:4
    // 10, 20, 30 -> 10: 1, 20: 1, 30:1

    //O(n) time complexity, O(1) space complexity
    void printFrequenciesInASortedArray(int[] arr){
       int current = arr[0];
       int count=1;
       for(int i=1; i<arr.length; i++){
           if(arr[i]!=current){
               System.out.println(current + ": " + count);
               count=1;
               current = arr[i];
           }else{
               count++;
           }
       }
       System.out.println(current+ ": " + count);
    }
}

class Main {
    public static void main(String[] args) {
        FrequenciesInASortedArray f = new FrequenciesInASortedArray();
        int arr[] = new int[]{10, 10, 20, 30, 30, 30}; // 10:2, 20:1, 30:3
        f.printFrequenciesInASortedArray(arr);

        System.out.println();

        arr = new int[]{10, 10, 10, 25, 30, 30};
        f.printFrequenciesInASortedArray(arr); // 10: 3, 25: 1, 30: 2
    }
}
