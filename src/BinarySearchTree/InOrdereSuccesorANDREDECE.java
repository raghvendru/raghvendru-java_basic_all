package BinarySearchTree;
import java.util.*;

public class InOrdereSuccesorANDREDECE {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    // Instance variables to store predecessor and successor
    private int predecessor = -1;
    private int successor = MAX_VALUE;

    // Function to find successor and predecessor in BST
    public List < Integer > succPredBST(TreeNode root, int key) {
        // Helper function to traverse the tree and find successor and predecessor
        traverse(root, key);

        // Return the result as a list with predecessor and successor
        return Arrays.asList(predecessor == -1 ? -1 : predecessor, successor == MAX_VALUE ? -1 : successor);
    }

    // Method to traverse the tree
    private void traverse(TreeNode node, int key) {
        if (node == null) {
            return;
        }
        if (node.data < key) {
            predecessor = Math.max(predecessor, node.data);
            traverse(node.right, key);
        } else if (node.data > key) {
            successor = Math.min(successor, node.data);
            traverse(node.left, key);
        } else {
            if (node.left != null) {
                TreeNode temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp.data;
            }

            if (node.right != null) {
                // Find minimum value in right subtree for successor
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp.data;
            }
        }
    }
    public static void main(String[] args) {
        InOrdereSuccesorANDREDECE solution = new InOrdereSuccesorANDREDECE();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        int key = 15;
        List < Integer > result = solution.succPredBST(root, key);
        System.out.println("Predecessor: " + result.get(0) + ", Successor: " + result.get(1));
    }
}

