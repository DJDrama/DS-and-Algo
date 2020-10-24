public class MoveAllZerosToEnd {
    void moveAllZerosToEnd(int[] arr){
        int current=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
                current++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MoveAllZerosToEnd mazte = new MoveAllZerosToEnd();
        int[] arr = {8, 5, 0, 10, 0, 20};
        // --> 8, 5, 10, 20, 0, 0

        //8, 5, 0, 10, 0, 20
        //1. 8 != 0 --> swap(8, 8), current++ //current=1;
        //2. 5 != 0 --> swap(5, 5), current++ //current=2
        //3. 0 == 0 pass
        //4. 10 != 0 --> swap(0, 10), current++ //current=3
        // {8, 5, 10, 0, 0, 20}
        //5. 0 == 0 pass
        //6. 20 != 0 --> swap(0, 20), current++ // current=4
        // {8, 5, 10, 20, 0, 0}
        //7. 0==0 pass
        mazte.moveAllZerosToEnd(arr);
        for(int num: arr)
            System.out.print(num+ " ");
    }
}
