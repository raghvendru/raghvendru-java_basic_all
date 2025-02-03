package BinarySearchTree;

public class CheckTReeIsBstOrNOT {
    public boolean isBST(TreeNode root) {
        // Helper function to validate the BST
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // Base case: if the node is null, return true
        if (node == null) return true;

        // Check if the node's value falls within the valid range
        if (node.data <= min || node.data >= max) return false;

        // Recursively validate the left subtree
        // Update the max value to the current node's value
        boolean leftIsValid = validate(node.left, min, node.data);

        // Recursively validate the right subtree
        // Update the min value to the current node's value
        boolean rightIsValid = validate(node.right, node.data, max);

        // Both subtrees must be valid for the tree to be a BST
        return leftIsValid && rightIsValid;
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(15);

        CheckTReeIsBstOrNOT solution = new CheckTReeIsBstOrNOT();
        System.out.println(solution.isBST(root)); // Output: false
    }
}

