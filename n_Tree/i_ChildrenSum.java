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

public class ChildrenSum {
    // Children sum property
    // sum of left and right should be equal to the parent node
    // O(n) time complexity
    // O(h) space complexity
    boolean isChildrenSum(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int sum = 0;
        if (root.left != null)
            sum += root.left.key;
        if (root.right != null)
            sum += root.right.key;
        return root.key == sum && isChildrenSum(root.left) && isChildrenSum(root.right);
    }


}

class Main {
    public static void main(String[] args) {
        /*
         *        110
         *       /  \
         *      20  90
         *         /  \
         *        40  50
         * */
        TreeNode root = new TreeNode(110);
        root.left = new TreeNode(20);
        root.right = new TreeNode(90);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);

        ChildrenSum c = new ChildrenSum();
        System.out.println(c.isChildrenSum(root));
    }
}
