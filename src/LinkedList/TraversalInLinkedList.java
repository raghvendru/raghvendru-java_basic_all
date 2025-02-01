package LinkedList;
import java.util.ArrayList;
import java.util.List;
public class TraversalInLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int data1) {
            val = data1;
            next = null;
        }
        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }
    public List<Integer> LLTraversal(ListNode head) {
        ListNode temp = head;
        List<Integer> ans = new ArrayList<>();
        while (temp != null) {
            ans.add(temp.val);
            temp = temp.next;
        }
        return ans;
    }
    public static void main(String[] args) {
        TraversalInLinkedList linkedList = new TraversalInLinkedList();
        // Creating nodes
        ListNode y1 = linkedList.new ListNode(2);
        ListNode y2 = linkedList.new ListNode(5);
        ListNode y3 = linkedList.new ListNode(8);
        ListNode y4 = linkedList.new ListNode(7);
        // Linking the nodes
        y1.next = y2;
        y2.next = y3;
        y3.next = y4;
        // Calling LLTraversal method
        List<Integer> result = linkedList.LLTraversal(y1);
        // Printing the result
        System.out.println("Linked List Values:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
