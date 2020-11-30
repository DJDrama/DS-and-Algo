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

public class MaximumWidthOfBinaryTree {
    // Maximum Width of Binary Tree
    // O(n) time complexity
    // O(w) space complexity (w = Maximum Width)
    int getMaxWidth(TreeNode root) {
        int res=0;
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            res = Math.max(res, size);
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        /*
         *        110
         *       /  \
         *      20  90
         *     /   /  \
         *    200 40  50   <-- Maximum Width (3)
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

        MaximumWidthOfBinaryTree c = new MaximumWidthOfBinaryTree();
        System.out.println(c.getMaxWidth(root)); // 3
    }
}
