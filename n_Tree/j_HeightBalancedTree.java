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

public class HeightBalancedTree {
    // A binary tree in which the left and right subtrees
    // of every node differ in height by no more than 1.
    // O(n) time complexity, O(h) space complexity
    int isBalanced(TreeNode root){
        if(root==null)
            return 0;

        int lh = isBalanced(root.left);
        if(lh==-1) return -1;

        int rh = isBalanced(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh)>1) return -1;
        else return Math.max(lh, rh)+1;
    }

}

class Main {
    public static void main(String[] args) {
        /*
         *        110
         *       /  \
         *      20  90
         *     /   /  \
         *    200 40  50
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

        HeightBalancedTree c = new HeightBalancedTree();
        System.out.println(c.isBalanced(root)); // False
    }
}
