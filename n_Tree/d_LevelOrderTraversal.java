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

public class LevelOrderTraversal {
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

        levelOrderTraversal(root); // 10 20 30 35 40 50
    }

    // Level order Traversal
    private static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.key + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }


}
