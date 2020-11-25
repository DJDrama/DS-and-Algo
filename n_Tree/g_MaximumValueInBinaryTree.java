import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int key;
    TreeNode right, left;

    TreeNode(int x) {
        this.key = x;
        left = right = null;
    }
}

public class MaximumValueInBinaryTree {
    public static void main(String[] args) {
        /*
         *        10
         *       /  \
         *      20  30
         *     /   /  \
         *    35  40  50
         * */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(35);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);

        System.out.println(getMaxValue(root)); // 50
    }

    // O(n) time complexity
    // O(w) space complexity
    private static int getMaxValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.key, Math.max(getMaxValue(root.left), getMaxValue(root.right)));
    }


}
