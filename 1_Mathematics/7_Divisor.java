public class Divisor {
    void allDivisors(int n){
        int i;
        for(i=1; i*i<n; i++){
            if(n%i==0)
                System.out.print(i+ " ");
        }
        for(; i>=1; i--){
            if(n%i==0)
                System.out.print(n/i + " ");
        }

    }
}

class Main{
    public static void main(String[] args){
        Divisor d = new Divisor();
        d.allDivisors(36);
    }
}
