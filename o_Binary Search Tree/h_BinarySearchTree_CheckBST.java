public class BinarySearchTree_CheckBST {
    boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        return root.key > min && root.key < max && isBST(root.left, min, root.key) &&
                isBST(root.right, root.key, max);
    }


    // O(n) time complexity
    // O(h) space complexity
    int prev = Integer.MIN_VALUE;
    boolean isBST(TreeNode root) {
        if (root == null) return true;
        if (!isBST(root.left)) return false;
        if (root.key <= prev) return false;
        prev = root.key;
        return isBST(root.right);
    }
}

class Main {
    public static void main(String[] args) {
            /*
                15
               /  \
              5   20
             /   /  \
            3   18  80
               /
              16
         */
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.left.left = new TreeNode(16);
        root.right.right = new TreeNode(80);

        BinarySearchTree_CheckBST b = new BinarySearchTree_CheckBST();
        // Method1
        System.out.println(b.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // Method2
        System.out.println(b.isBST(root));

    }


}

class TreeNode {
    TreeNode left, right;
    int key, lCount;

    TreeNode(int key) {
        this.key = key;
        this.lCount = 0;
        this.left = this.right = null;
    }
}
