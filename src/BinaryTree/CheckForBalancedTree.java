package BinaryTree;
public class CheckForBalancedTree {
    public boolean isBalanced(TreeNode root) {
        // Call the recursive helper method to check balance status.
        // If the heightDifference() returns -1, the tree is unbalanced.
        return dfsHeight(root) != -1;
    }
    /**
     * Recursive method to calculate the height of the tree.
     * Returns -1 if the tree is unbalanced, otherwise returns the height of the tree.
     *
     * @param root The current node of the tree.
     * @return The height of the tree if balanced, -1 if unbalanced.
     */
    private int dfsHeight(TreeNode root) {
        // Base case: If the current node is null, the height of an empty tree is 0.
        if (root == null) return 0;
        // Recursively calculate the height of the left subtree.
        int leftHeight = dfsHeight(root.left);
        // If the left subtree is unbalanced, propagate the unbalance status.
        if (leftHeight == -1) return -1;
        // Recursively calculate the height of the right subtree.
        int rightHeight = dfsHeight(root.right);
        // If the right subtree is unbalanced, propagate the unbalance status.
        if (rightHeight == -1) return -1;
        // Check if the difference in height between the left and right subtrees is greater than 1.
        // If the difference is greater, the tree is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        // Return the height of the tree rooted at the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        CheckForBalancedTree solution = new CheckForBalancedTree();
        if (solution.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}

