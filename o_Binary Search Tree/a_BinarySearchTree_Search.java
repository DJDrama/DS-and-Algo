public class BinarySearchTree_Search {
    // O(h) time complexity
    // O(h) space complexity
    boolean searchRecursive(TreeNode root, int key) {
        if (root == null) return false;
        if (root.key == key)
            return true;
        else if (root.key < key) {
            return searchRecursive(root.right, key);
        } else {
            return searchRecursive(root.left, key);
        }
    }

    // O(h) time complexity
    // O(1) space complexity
    boolean searchIterative(TreeNode root, int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.key == key)
                return true;
            else if (curr.key < key) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return false;
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

        BinarySearchTree_Search b = new BinarySearchTree_Search();
        int key = 16;
        // Recursive
        System.out.println(b.searchRecursive(root, key)); // True
        key = 4;
        System.out.println(b.searchRecursive(root, key)); // False

        // Iterative
        key = 20;
        System.out.println(b.searchIterative(root, key)); // True
        key = 120;
        System.out.println(b.searchIterative(root, key)); // False

    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}