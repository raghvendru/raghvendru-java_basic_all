package BinaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public List<Integer> postorder(TreeNode root) {
        // List to store postorder traversal result
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Stack to manage nodes during traversal
        Stack<TreeNode> stack1 = new Stack<>();
        // Stack to store nodes in reverse order
        Stack<TreeNode> stack2 = new Stack<>();

        // Start with the root node
        stack1.push(root);

        while (!stack1.isEmpty()) {
            // Pop a node from stack1
            TreeNode node = stack1.pop();
            // Push it to stack2
            stack2.push(node);

            if (node.left != null) {
                // Push left child to stack1
                stack1.push(node.left);
            }
            if (node.right != null) {
                // Push right child to stack1
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            // Pop nodes from stack2
            TreeNode node = stack2.pop();
            // Add node data to result
            result.add(node.data);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        PostOrder sol = new PostOrder();
        List<Integer> result = sol.postorder(root);

        // Print the result
        System.out.println(result);  // Output: [4, 5, 2, 6, 3, 1]
    }
}
