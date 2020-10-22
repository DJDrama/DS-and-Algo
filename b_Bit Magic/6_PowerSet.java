public class PowerSet {
    void printPowerSetUsingBitwiseOperators(String input) {
        int n = input.length();
        int pow = (int) Math.pow(2.0, n);
        for(int c=0; c<pow; c++){
            for(int i=0; i<n; i++){
                if((c& (1<<i)) !=0)
                    System.out.print(input.charAt(i));
            }
            System.out.println();
        }
  }
}

class Main {
    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();

        String s = "abc";
        // _, a, b, ab, c, ac, bc, abc
        // 000, 001, 010, 011, 100, 101, 110, 111
        powerSet.printPowerSetUsingBitwiseOperators(s);


    }
}
