class TreeNode {
    int key;
    TreeNode right, left;

    TreeNode(int x) {
        this.key = x;
        left = right = null;
    }
}

public class PrintNodesAtDistanceKFromRoot {
    public static void main(String[] args) {
        /*
         *        10
         *       /  \
         *      20  30
         *         /  \
         *        40  50
         * */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);

        int k = 2;
        printNodesAtDistanceKFromRoot(root, k); // 40 50
    }

    // Print Nodes at distance k (from root)
    // O(n) time complexity, O(h) space complexity
    private static void printNodesAtDistanceKFromRoot(TreeNode root, int k) {
        if (root == null) return;
        if (k == 0)
            System.out.print(root.key + " ");
        else {
            printNodesAtDistanceKFromRoot(root.left, k - 1);
            printNodesAtDistanceKFromRoot(root.right, k - 1);
        }
    }


}
