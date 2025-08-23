package BinarySearchTree;
import java.util.ArrayList;
import java.util.*;

public class BstIterator {
    private Stack<TreeNode> stack;
    private boolean reverse;
    // Constructor to initialize the iterator
    public BstIterator(TreeNode root, boolean isReverse) {
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    // Helper function to push all left or right nodes
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = (reverse) ? node.right : node.left;
        }
    }

    // Check if there are more elements in the BST
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Get the next element in the inorder or reverse inorder traversal
    public int next() {
        TreeNode node = stack.pop();
        if (!reverse) pushAll(node.right);
        else pushAll(node.left);
        return node.data;
    }

    public boolean twoSumBST(TreeNode root, int k) {
        if (root == null) return false;
        //Initialize two iterators
        BstIterator l = new BstIterator(root, false); // normal inorder
        BstIterator r = new BstIterator(root, true);  // reverse inorder
        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
    public static void main(String[] args) {
        // Create the tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
      //  BstIterator solution = new BstIterator();
        int k = 9;

        // Check if there exist two elements in the BST such that their sum is equal to k
      //  boolean result = solution.twoSumBST(root, k);
      //  System.out.println(result ? "True" : "False");
    }
}

