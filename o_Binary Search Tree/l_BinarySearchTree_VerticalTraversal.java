import java.util.*;

public class BinarySearchTree_VerticalTraversal {
    // Vertical Traversal
    class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode n, int h) {
            this.node = n;
            this.hd = h;
        }
    }

    void vTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.node;
            int hd = p.hd;
            if (map.containsKey(hd))
                map.get(hd).add(curr.key);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.key);
                map.put(hd, list);
            }
            if (curr.left != null)
                q.offer(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.offer(new Pair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            for (int num : list)
                System.out.print(num + " ");
            System.out.println();
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

        BinarySearchTree_VerticalTraversal b = new BinarySearchTree_VerticalTraversal();
        b.vTraversal(root);
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
