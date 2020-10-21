public class Subsets {
    void printSubsets(String str, String curr, int index){
        if(index == str.length()){
            System.out.print(curr+" ");
            return;
        }
        printSubsets(str, curr, index+1);
        printSubsets(str, curr+str.charAt(index), index+1);
    }
}

/**
 * Given a string, point all subsets of it in any order
 */
class Main {
    public static void main(String[] args) {
        Subsets rc = new Subsets();

        String s = "abc";
        // "", c, b, bc, a, ac, ab, abc
        rc.printSubsets(s, "", 0);

    }
}
