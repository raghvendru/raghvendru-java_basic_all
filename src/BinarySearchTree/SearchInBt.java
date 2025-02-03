package BinarySearchTree;
import java.util.*;
 class TreeNode7 {
    int data;
    TreeNode7 left;
    TreeNode7 right;
    TreeNode7(int val) { data = val; left = null; right = null; }
}
public class SearchInBt {
    public TreeNode7 searchBST(TreeNode7 root, int val) {
        // Traverse the tree until we find the node
        // with the given value or reach the end
        while (root != null && root.data != val) {
            // Move to the left or right child
            // depending on the value comparison
            root = (root.data > val) ? root.left : root.right;
        }
        // Return the found node or null if not found
        return root;
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a simple BST for demonstration
        TreeNode7 root = new TreeNode7(4);
        root.left = new TreeNode7(2);
        root.right = new TreeNode7(7);
        root.left.left = new TreeNode7(1);
        root.left.right = new TreeNode7(3);

        SearchInBt sol = new SearchInBt();
        TreeNode7 result = sol.searchBST(root, 2);
        if (result != null) {
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Node not found");
        }
    }
}

