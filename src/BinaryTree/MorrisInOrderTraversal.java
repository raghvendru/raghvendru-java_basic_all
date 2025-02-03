package BinaryTree;
import java.util.*;
public class MorrisInOrderTraversal {
    public List<Integer> getInorder(TreeNode root) {
        // List to store inorder traversal
        List<Integer> inorder = new ArrayList<>();
        // Pointer to the current node
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                // Add current node's value and move to right child
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                // Find the predecessor
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                /* Establish a temporary link and move to the
                left child */
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                /* Remove the temporary link, add current node's value
                and move to the right child */
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        // Return inorder traversal
        return inorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        MorrisInOrderTraversal sol = new MorrisInOrderTraversal();
        List<Integer> inorder = sol.getInorder(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");
        for (int val : inorder) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
