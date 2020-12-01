public class BinarySearchTree_FixBSTWithTwoNodesSwapped {
    // O(n) time complexity
    // O(n) space complexity
    TreeNode prev = null, first = null, second = null;
    void fixBST(TreeNode root) {
        if (root == null) return;
        fixBST(root.left);
        if (prev != null && root.key < prev.key) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        fixBST(root.right);
    }
}

class Main {
    public static void main(String[] args) {
            /*
                15
               /  \
              5   20
             /   /  \
            3   80  18  <-- swap 80 & 18 to make BST
               /
              16
         */
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(80);
        root.right.left.left = new TreeNode(16);
        root.right.right = new TreeNode(18);

        BinarySearchTree_FixBSTWithTwoNodesSwapped b = new BinarySearchTree_FixBSTWithTwoNodesSwapped();
        printInorder(root);

        // Fix
        b.fixBST(root);

        // Swap
        int temp = b.first.key;
        b.first.key = b.second.key;
        b.second.key = temp;

        System.out.println();
        printInorder(root);

    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
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
