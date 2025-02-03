package BinaryTree;
import java.util.*;
public class MorrisPreOrder {
    public List<Integer> preorder(TreeNode root) {
        // List to store the preorder traversal result
        List<Integer> preorder = new ArrayList<>();
        // Pointer to the current node, starting with the root
        TreeNode cur = root;
        /*
        Iterate until the current node becomes null
        If the current node has no left child
        Add the value of the current node to the preorder list
        */
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.data);
                cur = cur.right;
            } else {
        /*
        If the current node has a left child create a pointer
        to traverse to the rightmost node in the left subtree
        or until we find a node whose right child is not yet processed
        */
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
        /*
        If the right child of the rightmost node is null
        set the right child of the rightmost node to the current node
        Add the value of the current node to the preorder list
        and move to the left child
        */
                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.data);
                    cur = cur.left;
                }

        /*
        If the right child of the rightmost node is not null
        Reset the right child to null and move to the right child
        */
                else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        // Return the resulting preorder traversal list
        return preorder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(2);
        MorrisPreOrder sol = new MorrisPreOrder();
        List<Integer> preorder = sol.preorder(root);
        System.out.println("Binary Tree Morris Preorder Traversal: " + preorder);
    }
}
