package BinaryTree;
import java.util.ArrayList;
import java.util.List;
import  java.util.*;
// Definition for a binary tree node
 class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
public class PreOrderTraversal {
    public List<Integer> preorder(TreeNode root) {
        // Initialize list to store
        // the preorder traversal result
        List<Integer> preorder = new ArrayList<>();
        // If the root is null, return
        // an empty traversal result
        if (root == null) {
            return preorder; }
        // Create a stack to store
        // nodes during traversal
        Stack<TreeNode> st = new Stack<>();
        // Push the root node
        // onto the stack
        st.push(root);
        // Perform iterative preorder traversal
        while (!st.empty()) {
            // Get the current node
            // from the top of the stack
            root = st.pop();
            // Add the node's value to
            // the preorder traversal result
            preorder.add(root.data);
            // Push the right child
            // onto the stack if exists
            if (root.right != null) {
                st.push(root.right);
            }
            // Push the left child onto
            // the stack if exists
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preorder;
    }
    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        PreOrderTraversal sol = new PreOrderTraversal();
        List<Integer> result = sol.preorder(root);
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
