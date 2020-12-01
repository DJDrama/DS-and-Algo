public class BinarySearchTree_Insert {
    // Recursive
    // O(h) time complexity
    // O(h) space complexity
    TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null)
            return new TreeNode(key);

        if (root.key > key) {
            root.left = insertRecursive(root.left, key);
        } else if (root.key < key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    // Iterative
    // O(h) time complexity
    // O(1) space complexity
    void insertIterative(TreeNode root, int key) {
        TreeNode temp = new TreeNode(key);
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.key > key)
                curr = curr.left;
            else if (curr.key < key)
                curr = curr.right;
            else
                return;
        }
        if (parent == null) // When root is null
            return; // return new node
        if (parent.key > key)
            parent.left = temp;
        else
            parent.right = temp;
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

        BinarySearchTree_Insert b = new BinarySearchTree_Insert();
        int insertKey = 17;
        b.insertRecursive(root, insertKey);
        printTreeInOrder(root);

        System.out.println("\n----------------------------------");

        insertKey = 6;
        b.insertIterative(root, insertKey);
        printTreeInOrder(root);

    }

    private static void printTreeInOrder(TreeNode root) {
        if (root == null) return;
        printTreeInOrder(root.left);
        System.out.print(root.key + " ");
        printTreeInOrder(root.right);
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