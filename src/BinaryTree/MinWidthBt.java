package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;
class Pair1{
    TreeNode node;
    int num;


    Pair1(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
public class MinWidthBt {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair1> queue = new LinkedList<>();
        queue.offer(new Pair1(root, 0));
        int width = 0;
        while(!queue.isEmpty()){
            int size = queue.size();


            Pair1 temp = queue.peek();
            int minimum = temp.num;


            int first = 0, last = 0;


            for(int i = 0; i < size; i++){
                Pair1 Pair1 = queue.poll();
                TreeNode node = Pair1.node;
                int num = Pair1.num;
                int current = num - minimum;
                if(i == 0) first = current;
                if(i == size-1) last = current;


                if(node.left != null) queue.offer(new Pair1(node.left, 2*current+1));
                if(node.right != null) queue.offer(new Pair1(node.right, 2*current+2));


            }
            width = Math.max(width, last - first + 1); // Corrected here
        }
        return width;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        MinWidthBt sol = new MinWidthBt();
        int maxWidth = sol.widthOfBinaryTree(root);
        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}

