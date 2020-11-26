import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int k) {
        key = k;
        left = right = null;
    }
}

public class LeftViewOfTree {
    //print left views of binary tree
    private int maxLevel = 0;
    // O(h) time complexity, O(h) space complexity
    void printLeftViewsRecursively(TreeNode root, int level) {
        if (root == null) return;
        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        printLeftViewsRecursively(root.left, level + 1);
        printLeftViewsRecursively(root.right, level + 1);
    }

    // O(h) time complexity, O(w) space complexity
    void printLeftViewsIteratively(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(i==0){
                    System.out.print(curr.key+ " ");
                }
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        /*
         *        10
         *       /  \
         *      20  30
         *     /   /  \
         *    35  40  50
         * */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(35);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);

        LeftViewOfTree l = new LeftViewOfTree();

        // Recursive
        int level = 1;
        l.printLeftViewsRecursively(root, level); // 10 20 35 (left nodes)

        System.out.println();

        // Iterative
        l.printLeftViewsIteratively(root);
    }
}
