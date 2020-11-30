import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}

public class DiameterOfBinaryTree {
    // diameter of a Binary Tree are discussed.
    // (longest path and return no of nodes)
    // diameter = number of nodes(longest path) between two leaf nodes

    // O(n) time complexity (Visit Every Node Once)
    // O(n) space complexity
    int res=0;
    int height(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        res = Math.max(res, 1 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
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

        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        System.out.println("Height : " + d.height(root));
        System.out.println("Diameter : " + d.res); // 6 (12 ~ 40 OR 12 ~ 50)

    }


}
