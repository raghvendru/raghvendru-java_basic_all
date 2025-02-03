package BinaryTree;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
class Pair {
    TreeNode root;
    int val;

    public Pair(TreeNode root, int val) {
        this.root = root;
        this.val = val;
    }
}
public class PrePostInorderInOneTraversal {
    public static List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null) {
            return Arrays.asList(inOrder, pre, post);
        }
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair it = st.pop();
            if (it.val == 1) {
                pre.add(it.root.data);
                it.val++;
                st.push(it);
                if (it.root.left != null) {
                    st.push(new Pair(it.root.left, 1));
                }
            } else if (it.val == 2) {
                inOrder.add(it.root.data);
                it.val++;
                st.push(it);
                if (it.root.right != null) {
                    st.push(new Pair(it.root.right, 1));
                }
            } else {
                post.add(it.root.data);
            }
        }
        return Arrays.asList(inOrder, pre, post);
    }
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> traversals = treeTraversal(root);
        List<Integer> inOrder = traversals.get(0);
        List<Integer> pre = traversals.get(1);
        List<Integer> post = traversals.get(2);
        System.out.print("Preorder traversal: ");
        printList(pre);
        System.out.print("Inorder traversal: ");
        printList(inOrder);
        System.out.print("Postorder traversal: ");
        printList(post);
    }
}

