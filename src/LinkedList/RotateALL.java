package LinkedList;

public class RotateALL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        temp.next = head;
        // When k is more than length of list
        k = k % length;
        // To get end of the list
        int end = length - k;
        while (end-- > 0)
            temp = temp.next;

        // Breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
    }
    // Utility function to insert node at the end of the list
    public static void insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }
    // Utility function to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // Inserting nodes
        insertNode(head, 2);
        insertNode(head, 3);
        insertNode(head, 4);
        insertNode(head, 5);
        System.out.print("Original list: ");
        printList(head);
        int k = 2;
        RotateALL solution = new RotateALL();
        ListNode newHead = solution.rotateRight(head, k);
        System.out.print("After " + k + " iterations: ");
        printList(newHead);
    }
}