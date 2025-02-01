package LinkedList;

class ListNode6 {
    int val;
    ListNode6 next;
    ListNode6 prev;
    ListNode6(int data1) {
        val = data1;
        next = null;
        prev = null;}
    ListNode6(int data1, ListNode6 next1, ListNode6 prev1) {
        val = data1;
        next = next1;
        prev = prev1;}}
public class DeleteAllOccurancesofKDLL {
    public ListNode6 deleteAllOccurrences(ListNode6 head, int target) {
        ListNode6 temp = head;
        while (temp != null) {
            if (temp.val == target) {
                // Update head if needed
                if (temp == head) {
                    head = temp.next;  }
                ListNode6 nextNode = temp.next;
                ListNode6 prevNode = temp.prev;
                if (nextNode != null) {
                    nextNode.prev = prevNode; }
                if (prevNode != null) {
                    prevNode.next = nextNode; }
                temp = nextNode;
            } else {
                temp = temp.next; }
        }
        return head;
    }
    public static void printList(ListNode6 head) {
        ListNode6 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode6 newNode(int data) {
        return new ListNode6(data);
    }
    public static void main(String[] args) {
        ListNode6 head = newNode(1);
        head.next = newNode(2);
        head.next.prev = head;
        head.next.next = newNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = newNode(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = newNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = newNode(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = newNode(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        System.out.print("Original list: ");
        printList(head);
        DeleteAllOccurancesofKDLL sol = new DeleteAllOccurancesofKDLL();
        head = sol.deleteAllOccurrences(head, 2);
        System.out.print("Modified list: ");
        printList(head);
    }
}
