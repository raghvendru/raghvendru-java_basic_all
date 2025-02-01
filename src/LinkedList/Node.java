package LinkedList;


    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int value,Node next1,Node prev1){
            this.data  = value;
            this.next = next1;
            this.prev = prev1;
        }

        public  Node (int data1) {
            this.data = data1;
            this.next = null;
            this.prev = null;
        }

        public static Node Convert(int[] arr){
            int n = arr.length;
            Node head = new Node(arr[0]);
            Node prev = head;
            for(int i =1;i<n;i++){
                Node temp = new Node(arr[i],null,prev);
                prev.next = temp;
                prev = temp;
            }
            return head;
        }

        private static void printLL(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int[] arr = {1,2,3};
            Node ans = Convert(arr);
            printLL(ans);
        }

}
