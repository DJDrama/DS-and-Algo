class TreeNode {
    int key;
    TreeNode right, left;

    TreeNode(int x) {
        this.key = x;
        left = right = null;
    }
}

public class TreeTraversal {
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

        inorderTraversal(root); // 20 10 40 30 50
        System.out.println();

        preOrderTraversal(root); // 10 20 30 40 50
        System.out.println();

        postOrderTraversal(root); // 20 40 50 30 10
        System.out.println();
    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.key + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.key + " ");
    }
}
