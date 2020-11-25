class TreeNode {
    int key;
    TreeNode right, left;

    TreeNode(int x) {
        this.key = x;
        left = right = null;
    }
}

public class HeightOfBinaryTree {
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

        System.out.println("Height : " + heightOfBinaryTree(root)); // 3
    }

    // O(n) time complexity
    // O(h) space complexity (h = height of tree)
    private static int heightOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
    }


}
