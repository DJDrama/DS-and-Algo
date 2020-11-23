public class TwoStacks {
    int capacity;
    int top1, top2;
    int[] arr;

    TwoStacks(int n) {
        arr = new int[n];
        capacity = n;
        top1 = -1;
        top2 = capacity;
    }
    void push1(int x){
        if(top1<top2-1){
            top1++;
            arr[top1]=x;
        }else{
            System.out.println("Stack Overflow");
            System.exit(-1);
        }
    }
    void push2(int x){
        if(top1<top2-1){
            top2--;
            arr[top2]=x;
        }else{
            System.out.println("Stack Overflow");
            System.exit(-1);
        }
    }
    int pop1(){
        if(top1>-1){
            return arr[top1--];
        }else{
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
        return 0;
    }
    int pop2(){
        if(top2<capacity){
            return arr[top2++];
        }else{
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
        return 0;
    }
}
class Main{
    public static void main(String[] args){
        int capacity=5;
        TwoStacks t = new TwoStacks(capacity);
        t.push1(5);
        t.push2(10);
        t.push2(15);
        t.push1(11);
        t.push2(7);
        System.out.println("Popped element from stack1 is: " + t.pop1());
        t.push2(40);
        System.out.println("Popped element from stack2 is: " + t.pop2());
    }
}
