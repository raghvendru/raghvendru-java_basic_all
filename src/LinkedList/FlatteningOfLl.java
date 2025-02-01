package LinkedList;
import java.util.*;
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2 child;

    ListNode2() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode2(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode2(int data1, ListNode2 next1, ListNode2 next2) {
        val = data1;
        next = next1;
        child = next1;
    }
}
public class FlatteningOfLl {
    private ListNode2 merge(ListNode2 list1, ListNode2 list2) {
        ListNode2 dummyNode = new ListNode2(-1);
        ListNode2 res = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;}
            res.next = null;}
        if (list1 != null) {
            res.child = list1;}
        else {
            res.child = list2;}
        if (dummyNode.child != null) {
            dummyNode.child.next = null;}
        return dummyNode.child;
    }
    public ListNode2 flattenLinkedList(ListNode2 head) {
        if (head == null || head.next == null) {
            return head;}
        ListNode2 mergedHead = flattenLinkedList(head.next);
        head = merge(head, mergedHead);
        return head;}
    public static void printLinkedList(ListNode2 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }
    public static void printOriginalLinkedList(ListNode2 head, int depth) {
        while (head != null) {
            System.out.print(head.val);
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);}
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");}
            }
            head = head.next;}
    }
    public static void main(String[] args) {
        ListNode2 head = new ListNode2(5);
        head.child = new ListNode2(14);
        head.next = new ListNode2(10);
        head.next.child = new ListNode2(4);
        head.next.next = new ListNode2(12);
        head.next.next.child = new ListNode2(20);
        head.next.next.child.child = new ListNode2(13);
        head.next.next.next = new ListNode2(7);
        head.next.next.next.child = new ListNode2(17);
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);
        FlatteningOfLl sol = new FlatteningOfLl();
        ListNode2 flattened = sol.flattenLinkedList(head);
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}

