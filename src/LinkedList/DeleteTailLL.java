package LinkedList;

public class DeleteTailLL {
    class ListNode {
        int val;
        DeleteTailLL.ListNode next;
        ListNode() {
            val = 0;
            next = null;
        }
        ListNode(int data1) {
            val = data1;
            next = null;
        }
        ListNode(int data1, DeleteTailLL.ListNode next1) {
            val = data1;
            next = next1;
        }
    }
    public DeleteTailLL.ListNode deleteTail(DeleteTailLL.ListNode head) {
        if (head == null || head.next == null) {
            return null; // Return null
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public DeleteTailLL.ListNode  deleteNodeWithValueX(DeleteTailLL.ListNode  head, int X) {
        if (head == null)
            return head;
        if (head.val == X) {
            head = head.next;
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.val == X) {
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public DeleteTailLL.ListNode deleteKthNode(DeleteTailLL.ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 1) {
            ListNode temp = head;
            head = head.next;
            return head;
        }
        ListNode temp = head;
        for (int i = 0; temp != null && i < k - 2; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return head;
        ListNode next = temp.next.next;
        temp.next = next;
        return head;
    }
    private void printList(DeleteTailLL.ListNode head) {
        DeleteTailLL.ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public DeleteTailLL.ListNode insertAtHead(DeleteTailLL.ListNode head, int data) {
        DeleteTailLL.ListNode newNode = new DeleteTailLL.ListNode(data);
        newNode.next = head;
        return newNode;
    }
    public static void main(String[] args) {
        DeleteTailLL sol = new DeleteTailLL(); // Create instance
        DeleteTailLL.ListNode head = sol.insertAtHead(null, 3);
        head = sol.insertAtHead(head, 2);
        head = sol.insertAtHead(head, 1);
        System.out.print("Original list: ");
        sol.printList(head);
        // Delete head
        head = sol.deleteTail(head);
        int k = 2;
        System.out.print("List after deleting head: ");
        sol.printList(head);
    }
}
