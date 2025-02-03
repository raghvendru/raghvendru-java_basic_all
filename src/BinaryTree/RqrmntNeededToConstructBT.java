package BinaryTree;

public class RqrmntNeededToConstructBT {
    public boolean uniqueBinaryTree(int a, int b) {
        // Return false if both traversals are the same
        // or if they are preorder and postorder
        return !(a == b || (a == 1 && b == 3) || (a == 3 && b == 1));
    }

    public static void main(String[] args) {
        RqrmntNeededToConstructBT solution = new RqrmntNeededToConstructBT();
        // Example test cases
        System.out.println(solution.uniqueBinaryTree(1, 2));
        System.out.println(solution.uniqueBinaryTree(1, 3));
    }
}
