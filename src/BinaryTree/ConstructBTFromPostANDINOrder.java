package BinaryTree;
import java.util.*;
public class ConstructBTFromPostANDINOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }
    public TreeNode buildTreePostIn(int[] inorder, int is, int ie,
                                    int[] postorder, int ps, int pe, Map<Integer, Integer> hm) {
        // Base case: If the subtree
        // is empty, return null
        if (ps > pe || is > ie) {
            return null;
        }
        // Create a new TreeNode
        // with the root value from postorder
        TreeNode root = new TreeNode(postorder[pe]);
        // Find the index of the root
        // value in inorder traversal
        int inRoot = hm.get(postorder[pe]);
        // Number of nodes in the left subtree
        int numsLeft = inRoot - is;
        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder,
                ps, ps + numsLeft - 1, hm);

        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder,
                ps + numsLeft, pe - 1, hm);
        return root;
    }
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};
        System.out.print("Inorder Array: ");
        printArray(inorder);
        System.out.print("Postorder Array: ");
        printArray(postorder);
        ConstructBTFromPostANDINOrder sol = new ConstructBTFromPostANDINOrder();
        TreeNode root = sol.buildTree(inorder, postorder);
        System.out.println("Inorder of Unique Binary Tree Created: ");
        printInorder(root);
        System.out.println();
    }
}
