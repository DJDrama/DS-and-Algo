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

public class SizeOfTree {
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

        System.out.println(sizeOfTree(root)); // 6 (6 nodes)
    }

    // O(n) time complexity
    // O(h) space complexity
    private static int sizeOfTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }


}
