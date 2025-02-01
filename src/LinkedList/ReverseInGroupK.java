package LinkedList;
public class ReverseInGroupK {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next; }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while (temp != null) {
            ListNode kThNode = getKthNode(temp, k);
            if (kThNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;}
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            reverseLinkedList(temp);
            if (temp == head) {
                head = kThNode;
            } else {
                prevLast.next = kThNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next; }
        System.out.println();
    }
    public static void main(String[] args) {
        // Create a linked list with values 5, 4, 3, 7, 9 and 2
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        System.out.print("Original Linked List: ");
        printLinkedList(head);
        ReverseInGroupK solution = new ReverseInGroupK();
        head = solution.reverseKGroup(head, 4);
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}

