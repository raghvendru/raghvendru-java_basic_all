package BinaryTree;
import java.util.*;
public class MinTimeToBurnBT {
    public int timeToBurnTree(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }
    private TreeNode bfsToMapParents(TreeNode root, HashMap<TreeNode, TreeNode> mpp, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.data == start) res = node;
            if (node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    private int findMaxDistance(HashMap<TreeNode, TreeNode> mpp, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        HashMap<TreeNode, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int fl = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if (node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }
                if (mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if (fl == 1) maxi++;
        }
        return maxi;
    }
    public static void main(String[] args) {
        MinTimeToBurnBT sol = new MinTimeToBurnBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int start = 4;
        int result = sol.timeToBurnTree(root, start);
        System.out.println("Time to burn the tree: " + result);
    }
}
