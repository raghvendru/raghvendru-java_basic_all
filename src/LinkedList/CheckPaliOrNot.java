package LinkedList;
import java.util.*;
public class CheckPaliOrNot {
        private ListNode reverseLinkedList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseLinkedList(head.next);
            ListNode front = head.next;
            front.next = head;
            head.next = null;
            return newHead;
        }
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                // It's a palindrome by definition
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                // Move slow pointer one step
                slow = slow.next;
                // Move fast pointer two steps
                fast = fast.next.next;
            }
            ListNode newHead = reverseLinkedList(slow.next);
            ListNode first = head;
            ListNode second = newHead;
            while (second != null) {
                if (first.val != second.val) {
                    reverseLinkedList(newHead);
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            reverseLinkedList(newHead);
            return true;
        }
        static void printLinkedList(ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        public static void main(String[] args) {
            /*Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome)*/
            ListNode head = new ListNode(1);
            head.next = new ListNode(5);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(5);
            head.next.next.next.next = new ListNode(1);
            System.out.print("Original Linked List: ");
            printLinkedList(head);
            CheckPaliOrNot solution = new CheckPaliOrNot();
            if (solution.isPalindrome(head)) {
                System.out.println("The linked list is a palindrome.");
            } else {
                System.out.println("The linked list is not a palindrome.");
            }
        }
    }