package LinkedList;

public class SortLLo12 {
    // Function to sort the linked list
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.val == 2) {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        ListNode newHead = zeroHead.next;
        return newHead;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    // Function to create new node
    public static ListNode newNode(int data) {
        ListNode node = new ListNode(data);
        return node;
    }
    public static void main(String[] args) {
        // Creating a linked list
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(0);
        head.next.next.next = newNode(1);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(0);
        head.next.next.next.next.next.next = newNode(1);
        System.out.print("Original list: ");
        printList(head);
        SortLLo12 sol = new SortLLo12();
        head = sol.sortList(head);
        System.out.print("Sorted list: ");
        printList(head);
    }
}

