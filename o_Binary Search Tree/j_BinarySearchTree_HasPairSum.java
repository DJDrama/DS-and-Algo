import java.util.HashSet;

public class BinarySearchTree_HasPairSum {

    // O(n) time complexity
    // O(n) space complexity
    boolean hasPairSum(TreeNode root, int sum, HashSet<Integer> set) {
        if (root == null) return false;
        if (hasPairSum(root.left, sum, set))
            return true;

        if (set.contains(sum - root.key))
            return true;
        else
            set.add(root.key);

        return hasPairSum(root.right, sum, set);
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

        BinarySearchTree_HasPairSum b = new BinarySearchTree_HasPairSum();
        HashSet<Integer> set = new HashSet<>();
        System.out.println(b.hasPairSum(root, 23, set)); // TRUE
        System.out.println(b.hasPairSum(root, 99, set)); // FALSE
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
