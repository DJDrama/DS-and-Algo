class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}

public class ConstructBTFromInorderAndPreorder {
    // Construction of a Binary Tree from Inorder and Preorder traversal.
    // only in+pre, or in+post to construct a tree
    // in = {20, 10, 30}, pre = {10, 20, 30}
    private int preIndex = 0;

    TreeNode constructTree(int[] in, int[] pre, int is, int ie) {
        if (is > ie) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.left = constructTree(in, pre, is, inIndex - 1);
        root.right = constructTree(in, pre, inIndex + 1, ie);
        return root;
    }
}

class Main {
    public static void main(String[] args) {
        int[] in = {20, 10, 30};
        int[] pre = {10, 20, 30};

        ConstructBTFromInorderAndPreorder c = new ConstructBTFromInorderAndPreorder();
        TreeNode root = c.constructTree(in, pre, 0, in.length - 1);
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }

}
