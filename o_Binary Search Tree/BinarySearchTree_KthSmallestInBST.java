public class BinarySearchTree_KthSmallestInBST {
    // find k-th smallest binary search tree
    // 10, 5, 15, 20, 2 --> k=3 --> 10
    TreeNode kthSmallest(TreeNode root, int k) {
        if(root==null) return null;
        int count = root.lCount+1;
        if(count==k)
            return root;
        if(count > k)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right, k-count);
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        BinarySearchTree_KthSmallestInBST b = new BinarySearchTree_KthSmallestInBST();
        TreeNode root = null;

        // Insert and make a BST
        for (int num : arr)
            root = insertValuesToTree(root, num);

        printInorder(root);

        System.out.println();
        int k = 3;
        System.out.println(k + "rd smallest : " + b.kthSmallest(root, k).key);
    }

    private static TreeNode insertValuesToTree(TreeNode root, int x) {
        if (root == null) return new TreeNode(x);
        if (root.key > x) {
            root.left = insertValuesToTree(root.left, x);
            root.lCount++;
        } else if (root.key < x)
            root.right = insertValuesToTree(root.right, x);
        return root;
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
