import java.util.ArrayList;

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}

public class SerializeDeSerializeTree {
    // serialize and deserialize a binary tree.
    // serialize : string or array
    // deserialize : tree
    private static final int EMPTY = -1;

    void serialize(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(EMPTY);
            return;
        }
        arr.add(root.key);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    private int index=0;
    TreeNode deserialize(ArrayList<Integer> arr){
        if(index==arr.size()) return null;
        int value = arr.get(index++);
        if(value==EMPTY) return null;
        TreeNode root = new TreeNode(value);
        root.left = deserialize(arr);
        root.right = deserialize(arr);
        return root;
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

        SerializeDeSerializeTree l = new SerializeDeSerializeTree();
    }


}
