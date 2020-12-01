public class BinarySearchTree_Ceil {

    // O(h) time complexity
    // O(1) space complexity
    TreeNode ceil(TreeNode root, int x) {
        TreeNode res = null;
        while (root != null) {
            if (root.key == x)
                return root;
            else if (root.key < x) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
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

        BinarySearchTree_Ceil d = new BinarySearchTree_Ceil();
        System.out.println(d.ceil(root, 19).key); // 20
        System.out.println(d.ceil(root, 80).key); // 80
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