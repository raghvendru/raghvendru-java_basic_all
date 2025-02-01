package LinkedList;
import java.util.*;
public class LengthOfloop {
    int findLength(ListNode slow, ListNode fast) {
        // Count to keep track of nodes encountered in loop
        int cnt = 1;

        // Move fast by one step
        fast = fast.next;

        // Traverse fast till it reaches back to slow
        while (slow != fast) {
            /* At each node
            increase count by 1
            move fast forward
            by one step */
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }
    // Function to find the length of the loop
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // If the slow and fast pointers meet
            // there is a loop
            if (slow == fast) {
                // return the number of nodes
                return findLength(slow, fast);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        // Create a sample linked list with a loop
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Create a loop from fifth to second
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second;

        LengthOfloop solution = new LengthOfloop();
        int loopLength = solution.findLengthOfLoop(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}


