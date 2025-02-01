package LinkedList;

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        /* If the list is empty or has only one node,
         * return null as there is no middle node to delete */
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;
        return head;
    }

    // Function to print the linked list
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Deleting the middle node
        DeleteMiddleNode solution = new DeleteMiddleNode();
        head = solution.deleteMiddle(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}


