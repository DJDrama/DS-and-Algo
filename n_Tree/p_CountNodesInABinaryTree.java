class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}

public class CountNodesInABinaryTree {

    int getCountOfNodes(TreeNode root) {
        int lh = 0, rh = 0;
        TreeNode curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh)
            return (int) Math.pow(2, lh) - 1;

        return 1 + getCountOfNodes(root.left) + getCountOfNodes(root.right);
    }
}

class Main {
    public static void main(String[] args) {
        /*
         *        110
         *       /  \
         *      20  90
         *     /   /  \
         *    200 40  50
         *   /
         *  12
         *
         * */
        TreeNode root = new TreeNode(110);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(200);
        root.left.left.left = new TreeNode(12);
        root.right = new TreeNode(90);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);

        CountNodesInABinaryTree l = new CountNodesInABinaryTree();

        System.out.println(l.getCountOfNodes(root));
    }


}
