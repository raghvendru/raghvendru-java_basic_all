package LinkedList;
import java.util.*;
public class RemoveNthNodeFromBackofLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Creating pointers
        ListNode fastp = head;
        ListNode slowp = head;

        /* Move the fastp pointer
        N nodes ahead */
        for (int i = 0; i < n; i++) {
            fastp = fastp.next;
        }

        /* If fastp becomes NULL
        the Nth node from the
        end is the head */
        if (fastp == null) {
            return head.next;
        }

        /* Move both pointers
        Until fastp reaches the end */
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = slowp.next;
        slowp.next = slowp.next.next;
        return head;
    }


// Function to print the linked list
public static void printLL(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
    }
    System.out.println();
}

public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
    int N = 3;
    // Creation of linked list
    ListNode head = new ListNode(arr.get(0));
    head.next = new ListNode(arr.get(1));
    head.next.next = new ListNode(arr.get(2));
    head.next.next.next = new ListNode(arr.get(3));
    head.next.next.next.next = new ListNode(arr.get(4));

    // Solution instance
    RemoveNthNodeFromBackofLL sol = new RemoveNthNodeFromBackofLL();
    head = sol.removeNthFromEnd(head, N);
    printLL(head);
}

}

