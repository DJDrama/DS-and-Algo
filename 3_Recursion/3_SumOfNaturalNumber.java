public class SumOfNaturalNumber {

    // Time Complexity: O(n)
    // Space Complexity : O(n)
    int sumOfNaturalNumber(int n){
        if(n==0)
            return 0;
        return n+sumOfNaturalNumber(n-1);
    }

}

class Main {
    public static void main(String[] args) {
        SumOfNaturalNumber sumOfNaturalNumber = new SumOfNaturalNumber();
        System.out.println(sumOfNaturalNumber.sumOfNaturalNumber(10));
    }
}
