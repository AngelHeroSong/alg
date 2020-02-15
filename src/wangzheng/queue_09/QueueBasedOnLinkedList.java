package wangzheng.queue_09;

public class QueueBasedOnLinkedList {

    private Node head = null;
    private Node tail = null;

    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;

        }
    }

    public String dequeue() {

        if (head == null) {
            return null;
        }
        String ret = head.getData();
        head = head.next;
        if (head == null){
            tail = null;
        }
        return ret;
    }

    public void printAll(){
        Node cur = head;
        while(cur!=null){
            System.out.println(cur.getData()+" ");
            cur = cur.next;

        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queueBasedOnLinkedList = new QueueBasedOnLinkedList();


        queueBasedOnLinkedList.enqueue("1");
        queueBasedOnLinkedList.enqueue("2");
        queueBasedOnLinkedList.enqueue("3");
        queueBasedOnLinkedList.printAll();
        queueBasedOnLinkedList.dequeue();
        queueBasedOnLinkedList.printAll();

    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

}
