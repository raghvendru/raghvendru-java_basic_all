package BinarySearchTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class KthSmallestLArgestElementinBst {
    private int k;
    private int result;
    // Function to find the kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        inorder(root);
        return result;
    }
    // Helper function for inorder traversal
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            if (--k == 0) {
                result = node.data;
                return;
            }
            inorder(node.right);
        }
    }
    // Function to find the kth largest element
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        reverseInorder(root);
        return result;
    }
    // Helper function for reverse inorder traversal
    private void reverseInorder(TreeNode node) {
        if (node != null) {
            reverseInorder(node.right);
            if (--k == 0) {
                result = node.data;
                return;
            }
            reverseInorder(node.left);
        }
    }
    // Function to return kth smallest and kth largest elements
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        result.add(kthSmallest(root, k));
        result.add(kthLargest(root, k));
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        KthSmallestLArgestElementinBst solution = new KthSmallestLArgestElementinBst();
        int k = 1;
        List<Integer> result = solution.kLargesSmall(root, k);

        // Output the result
        System.out.println(result); // Output: [1, 4]
    }
}
