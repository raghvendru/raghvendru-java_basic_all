package LinkedList;
import java.util.*;
public class IntersectionOfLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Traverse the second list
        while (headB != null) {
            // For each node in the second list,
            // Traverse the first list
            ListNode temp = headA;
            while (temp != null) {
                // If the current node
                // Of the first list is the
                // Same as the current node of
                // The second list
                if (temp == headB)
                    // Intersection node
                    return headB;
                // Move to the next node
                // In the first list
                temp = temp.next;
            }
            // Move to the next node
            // In the second list
            headB = headB.next;
        }
        // No intersection found
        return null;
    }
}

class Main {
    public static void insertNode(ListNode head, int val) {
        // Create a new node with the given value
        ListNode newNode = new ListNode(val);
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }
        // Otherwise, traverse to the end of the list
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        // Insert the new node at the end of the list
        temp.next = newNode;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        // Traverse the list
        while (head.next != null) {
            // Print the value of each node followed by an arrow
            System.out.print(head.val + "->");
            head = head.next;
        }
        // Print the value of the last node
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        // Creation of the first list
        ListNode head1 = new ListNode();
        insertNode(head1, 1);
        insertNode(head1, 3);
        insertNode(head1, 1);
        insertNode(head1, 2);
        insertNode(head1, 4);

        // Create an intersection
        ListNode intersection = head1.next.next.next;

        // Creation of the second list
        ListNode head2 = new ListNode();
        insertNode(head2, 3);
        head2.next = intersection;

        // Printing the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);

        // Checking if an intersection is present
        IntersectionOfLL sol = new IntersectionOfLL();
        ListNode answerNode = sol.getIntersectionNode(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection");
        else
            System.out.println("The intersection point is " + answerNode.val);
    }
}