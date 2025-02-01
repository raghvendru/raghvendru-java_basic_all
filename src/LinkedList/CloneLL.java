package LinkedList;
import java.util.*;
class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4 random;
    ListNode4() {
        val = 0;
        next = null;
        random = null;}
    ListNode4(int data1) {
        val = data1;
        next = null;
        random = null;}
    ListNode4(int data1, ListNode4 next1, ListNode4 r) {
        val = data1;
        next = next1;
        random = r;}}
public class CloneLL {
    void insertCopyInBetween(ListNode4 head) {
        ListNode4 temp = head;
        while (temp != null) {
            ListNode4 nextElement = temp.next;
            ListNode4 copy = new ListNode4(temp.val);
            copy.next = nextElement;
            temp.next = copy;
            temp = nextElement;
        }
    }

    void connectRandomPointers(ListNode4 head) {
        ListNode4 temp = head;
        while (temp != null) {
            ListNode4 copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    ListNode4 getDeepCopyList(ListNode4 head) {
        ListNode4 temp = head;
        ListNode4 dummyNode = new ListNode4(-1);
        ListNode4 res = dummyNode;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }

    ListNode4 copyRandomList(ListNode4 head) {
        if (head == null) return null;
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }

    public static void printClonedLinkedList(ListNode4 head) {
        while (head != null) {
            System.out.print("Data: " + head.val);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode4 head = new ListNode4(7);
        head.next = new ListNode4(14);
        head.next.next = new ListNode4(21);
        head.next.next.next = new ListNode4(28);
        head.random = head.next.next; // 7 -> 21
        head.next.random = head; // 14 -> 7
        head.next.next.random = head.next.next.next; // 21 -> 28
        head.next.next.next.random = head.next; // 28 -> 14
        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);
        CloneLL solution = new CloneLL();
        ListNode4 clonedList = solution.copyRandomList(head);
        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }
}