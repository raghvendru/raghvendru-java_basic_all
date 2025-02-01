package LinkedList;
        public class DeleteHeadInLL {
            class ListNode {
                int val;
                ListNode next;
                ListNode() {
                    val = 0;
                    next = null;
                }
                ListNode(int data1) {
                    val = data1;
                    next = null;
                }
                ListNode(int data1, ListNode next1) {
                    val = data1;
                    next = next1;
                }
            }
            public ListNode deleteHead(ListNode head) {
                if (head == null)
                    return null;
                ListNode temp = head;
                head = head.next;
                temp = null;
                return head;
            }
            private void printList(ListNode head) {
                ListNode current = head;
                while (current != null) {
                    System.out.print(current.val + " ");
                    current = current.next;
                }
                System.out.println();
            }
            public ListNode insertAtHead(ListNode head, int data) {
                ListNode newNode = new ListNode(data);
                newNode.next = head;
                return newNode;
            }
            public static void main(String[] args) {
                DeleteHeadInLL sol = new DeleteHeadInLL(); // Create instance
                ListNode head = sol.insertAtHead(null, 3);
                head = sol.insertAtHead(head, 2);
                head = sol.insertAtHead(head, 1);
                System.out.print("Original list: ");
                sol.printList(head);
                // Delete head
                head = sol.deleteHead(head);
                System.out.print("List after deleting head: ");
                sol.printList(head);
            }
        }



