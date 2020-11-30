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

public class TraversalInSpiralForm {

    // O(n) time complexity
    // O(n) space complexity

    void printSpiral(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack();
        boolean reverse = false;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (reverse) {
                    s.push(curr.key);
                } else {
                    System.out.print(curr.key + " ");
                }
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            if (reverse) {
                while (!s.isEmpty()) {
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse;
        }
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

        TraversalInSpiralForm t = new TraversalInSpiralForm();
        t.printSpiral(root); // 110 90 20 200 40 50 12
    }


}
