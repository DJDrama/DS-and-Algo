import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}

public class ConvertBinaryTreeToDoublyLinkedList {
    // Convert Binary tree to DLL
    // left==prev, right==next
    // Very Similar to InOrder
    // O(n) time complexity
    // O(h) space complexity
    private TreeNode prev=null;
    TreeNode BtToDll(TreeNode root){
        if(root==null) return null;
        TreeNode head = BtToDll(root.left);

        if(prev==null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        BtToDll(root.right);

        return head;
    }
}

class Main {
    public static void main(String[] args) {
        /*
         *        110
         *       /  \
         *      20  90
         *     /   /  \
         *    200 40  50   <-- Maximum Width (3)
         *   /
         *  12
         *
         * */
        TreeNode root = new TreeNode(110);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(200);
        root.left.left.left = new TreeNode(12);
        root.right = new TreeNode(90);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);

        ConvertBinaryTreeToDoublyLinkedList c = new ConvertBinaryTreeToDoublyLinkedList();
        TreeNode dll = c.BtToDll(root); //12->200->20->110->40->90->50
        printDLL(dll);
    }
    private static void printDLL(TreeNode dll){
        if(dll==null) return;
        while(dll!=null){
            System.out.print(dll.key+ " ");
            dll = dll.right;
        }
    }
}
