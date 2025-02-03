package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;
public class SerializeDEserIBT {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            if (curNode == null) {
                sb.append("#,");
            } else {
                sb.append(curNode.data).append(",");
                q.offer(curNode.left);
                q.offer(curNode.right);
            }
        }
        return sb.toString();
    }
    // Decode the encoded data to a tree
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        StringBuilder s = new StringBuilder(data);
        String str;
        int commaIndex = s.indexOf(",");
        str = s.substring(0, commaIndex);
        s.delete(0, commaIndex + 1);
        TreeNode root = new TreeNode(Integer.parseInt(str));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);
            if (!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                q.offer(leftNode);
            }
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerializeDEserIBT solution = new SerializeDEserIBT();
        System.out.print("Original Tree: ");
        inorder(root);
        System.out.println();
        String serialized = solution.serialize(root);
        System.out.println("Serialized: " + serialized);
        TreeNode deserialized = solution.deserialize(serialized);
        System.out.print("Tree after deserialization: ");
        inorder(deserialized);
        System.out.println();
    }
}
