public class BinarySearchTree_Delete {

    // O(h) time complexity
    // O(h) space complexity
    TreeNode delNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.key > key)
            root.left = delNode(root.left, key);
        else if (root.key < key)
            root.right = delNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode successor = getSuccessor(root);
                root.key = successor.key;
                root.right = delNode(root.right, successor.key);
            }
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode curr) {
        curr = curr.right;
        while (curr != null && curr.left != null)
            curr = curr.left;
        return curr;
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

        BinarySearchTree_Delete d = new BinarySearchTree_Delete();
        root = d.delNode(root, 18);
        printInOrder(root);
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.key + " ");
        printInOrder(root.right);
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