package BinaryTree;

public class CountTotalNodeInComBT {
    public int countNodes(TreeNode root) {
        // Base case: If the root
        // is NULL, there are no nodes
        if (root == null) {
            return 0;
        }
        // Find the left height and
        // right height of the tree
        int lh = findHeightLeft(root);
        int rh = findHeightRight(root);
        // Check if the last level
        // is completely filled
        if (lh == rh) {
            // If so, use the formula for
            // total nodes in a perfect
            // binary tree i.e. 2^h - 1
            return (1 << lh) - 1;
        }
        // If the last level is not completely
        // filled, recursively count nodes in
        // left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    // Function to find the left height of a tree
    private int findHeightLeft(TreeNode node) {
        int height = 0;
        // Traverse left child until
        // reaching the leftmost leaf
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    // Function to find the right height of a tree
    private int findHeightRight(TreeNode node) {
        int height = 0;
        // Traverse right child until
        // reaching the rightmost leaf
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        CountTotalNodeInComBT sol = new CountTotalNodeInComBT();
        int totalNodes = sol.countNodes(root);
        System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
    }
}


