package LinkedList;

public class InsertionInLL {
        class ListNode {
            int val;
            LinkedList.InsertionInLL.ListNode next;
            ListNode() {
                val = 0;
                next = null;
            }
            ListNode(int data1) {
                val = data1;
                next = null;
            }
            ListNode(int data1, LinkedList.InsertionInLL.ListNode next1) {
                val = data1;
                next = next1;
            }
        }
        private void printList(LinkedList.InsertionInLL.ListNode head) {
            LinkedList.InsertionInLL.ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    public ListNode insertAtTail(ListNode head, int X) {
        if (head == null)
            return new ListNode(X);

        ListNode temp = head;
        // Traversing until the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(X);
        temp.next = newNode;

        return head;

    }
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if (head == null) {
            if (K == 1)
                return new ListNode(X);
            else
                return head;
        }
        if (K == 1)
            return new ListNode(X, head);

        int cnt = 0;
        ListNode temp = head;

        /* Traverse the linked list
        to find the node at position k-1 */
        while (temp != null) {
            cnt++;
            if (cnt == K - 1) {
                /* Insert the new node after the node
                at position k-1 */
                ListNode newNode = new ListNode(X, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == X)
            return new ListNode(val, head);

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == X) {
                ListNode newNode = new ListNode(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
        public LinkedList.InsertionInLL.ListNode insertAtHead(LinkedList.InsertionInLL.ListNode head, int data) {
            LinkedList.InsertionInLL.ListNode newNode = new LinkedList.InsertionInLL.ListNode(data);
            newNode.next = head;
            return newNode;
        }
        public static void main(String[] args) {
            LinkedList.InsertionInLL sol = new LinkedList.InsertionInLL(); // Create instance
            LinkedList.InsertionInLL.ListNode head = sol.insertAtHead(null, 3);
            head = sol.insertAtHead(head, 2);
            head = sol.insertAtHead(head, 1);
            System.out.print("Original list: ");
            sol.printList(head);
        }
    }


