package class02;

public class Code01_fanzhuanlianbiao {

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = getNode();
        System.out.println(head.toString());
        Node n = reverseLinkedList(head);
        System.out.println(n.toString());

        DoubleNode dn = getDoubleNode();
        DoubleNode dn2 = reverseDoubleList(dn);
        System.out.println(dn2);
    }



    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode getDoubleNode(){
        DoubleNode dn = new DoubleNode(1);
        dn.last = null;
        dn.next = new DoubleNode(2);
        dn.next.last = dn;
        dn.next.next = new DoubleNode(3);
        dn.next.next.last = dn.next;
        dn.next.next.next = null;
        return dn;
    }


    public static Node getNode(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        return head;
    }
}
