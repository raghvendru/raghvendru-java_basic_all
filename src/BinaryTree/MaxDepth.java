package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }
        // Create a queue to hold nodes to be processed
        Queue<TreeNode> q = new LinkedList<>();
        // Push the root node into the queue
        q.add(root);
        // Initialize level to 0
        int level = 0;
        // While there are nodes in the queue
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                TreeNode front = q.poll();
                // Enqueue left child if it exists
                if (front.left != null) {
                    q.add(front.left);
                }
                // Enqueue right child if it exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to move to the next level
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Maximum Depth: " + solution.maxDepth(root));
    }
}
