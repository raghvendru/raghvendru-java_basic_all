package LinkedList;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int data) {
        this.val = data;
        this.next = null;
    }

    ListNode1(int data, ListNode1 next) {
        this.val = data;
        this.next = next;
    }
}
public class SegregateOddAndEven {
    public ListNode1 oddEvenList(ListNode1 head) {
        if (head == null || head.next == null)
            return head;
        ListNode1 odd = head;
        ListNode1 even = head.next;
        ListNode1 firstEven = head.next;
        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // Connect the last odd node to the first even node
        odd.next = firstEven;

        return head;
    }

    // Function to print the linked list
    public static void printLL(ListNode1 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6};
        ListNode1 head = new ListNode1(arr[0]);
        ListNode1 temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode1(arr[i]);
            temp = temp.next;
        }
        System.out.println("Original Linked List:");
        printLL(head);
        SegregateOddAndEven solution = new SegregateOddAndEven();
        head = solution.oddEvenList(head);
        System.out.println("New Linked List:");
        printLL(head);
    }
}
