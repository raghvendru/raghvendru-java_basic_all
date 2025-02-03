package BinaryTree;
import java.util.*;
public class ConstructBtFromPreNPostOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store indices
        // of elements in the inorder traversal
        Map<Integer, Integer> inMap = new HashMap<>();
        // Populate the map with indices // of elements in the inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
// to recursively build the tree         // Call the private helper function
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // Base case: If the start indices         // exceed the end indices, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // at the current preorder index        // Create a new TreeNode with value
        TreeNode root = new TreeNode(preorder[preStart]);
        // value in the inorder traversal        // Find the index of the current root
        int inRoot = inMap.get(root.data);
        // elements in the left subtree        // Calculate the number of
        int numsLeft = inRoot - inStart;
        // Recursively build the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, inMap);
        // Recursively build the right subtree
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);

        // Return the current root node
        return root;
    }
    // inorder traversal of a tree    // Function to print the
    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }
    // given array    // Function to print the
    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        ConstructBtFromPreNPostOrder sol = new ConstructBtFromPreNPostOrder();
        System.out.print("Inorder Array: ");
        sol.printArray(inorder);
        System.out.print("Preorder Array: ");
        sol.printArray(preorder);
        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println("Inorder of Unique Binary Tree Created:");
        sol.printInorder(root);
        System.out.println();
    }
}

