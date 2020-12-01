import java.util.Map;
import java.util.TreeMap;

public class BinarySearchTree_VerticalSum {
    // Vertical Sum In a Binary Tree
    void vSum(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        vSumR(root, 0, map);
        for (Map.Entry entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    private void vSumR(TreeNode root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null) return;
        vSumR(root.left, hd - 1, map);
        int pSum;
        if (map.get(hd) == null)
            pSum = 0;
        else
            pSum = map.get(hd);
        map.put(hd, pSum + root.key);
        vSumR(root.right, hd + 1, map);
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

        BinarySearchTree_VerticalSum b = new BinarySearchTree_VerticalSum();
        b.vSum(root);
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
