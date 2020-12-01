import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinarySearchTree_TopView {
    // Vertical Traversal
    class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode n, int h) {
            this.node = n;
            this.hd = h;
        }
    }

    void topView(TreeNode root) {
        if (root == null) return;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.node;
            int hd = p.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, curr.key);
            }
            if (curr.left != null)
                q.offer(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.offer(new Pair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
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

        BinarySearchTree_TopView b = new BinarySearchTree_TopView();
        b.topView(root); //3 5 15 20 80
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
