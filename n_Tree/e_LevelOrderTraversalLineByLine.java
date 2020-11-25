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

public class LevelOrderTraversalLineByLine {
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

        printLevelOrderLineByLine(root);
    }

    // O(n) time complexity
    // O(w) space complexity (w = width) or O(n) space complexity (where width can be n)
    private static void printLevelOrderLineByLine(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                TreeNode curr = q.poll();
                System.out.print(curr.key + " ");
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                size--;
            }
            System.out.println();
        }
    }


}
