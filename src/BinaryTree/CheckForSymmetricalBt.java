package BinaryTree;

public class CheckForSymmetricalBt {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return symmetry(root.left, root.right);
    }

    private boolean symmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // Both nodes are null, so symmetric
        }

        if (left == null || right == null) {
            return false; // One of the nodes is null, so not symmetric
        }

        if (left.data != right.data) {
            return false; // The values of the nodes do not match, so not symmetric
        }

        // Recursively check the children of the nodes
        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }

    public static void main(String[] args) {
        CheckForSymmetricalBt solution = new CheckForSymmetricalBt();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root)); // Output: true
    }
}

