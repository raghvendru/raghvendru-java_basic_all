package LinkedList;
import java.util.*;
class ListNode7 {
    int val;
    ListNode7 next;
    ListNode7 prev;
    ListNode7(int data1) {
        val = data1;
        next = null;
        prev = null;
    }
}
public class RemoveDupDLL {
    public ListNode7 removeDuplicates(ListNode7 head) {
        ListNode7 temp = head;
        while (temp != null && temp.next != null) {
            ListNode7 nextNode = temp.next;
            while (nextNode != null && nextNode.val == temp.val) {
                ListNode7 duplicate = nextNode;
                nextNode = nextNode.next;
                duplicate = null;
            }
            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }

    public static void printList(ListNode7 head) {
        ListNode7 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode7 newNode(int data) {
        return new ListNode7(data);
    }
    public static void main(String[] args) {
        ListNode7 head = newNode(1);
        head.next = newNode(2);
        head.next.prev = head;
        head.next.next = newNode(2);
        head.next.next.prev = head.next;
        head.next.next.next = newNode(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = newNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = newNode(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        System.out.print("Original list: ");
        printList(head);
        RemoveDupDLL sol = new RemoveDupDLL();
        head = sol.removeDuplicates(head);
        System.out.print("Modified list: ");
        printList(head);
    }
}

