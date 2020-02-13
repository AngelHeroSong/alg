package wangzheng.linkedlist_06;

public class LinkedListAlgo {

    public static Node reverse(Node list){
      Node curr = list,pre = null;
      while(curr!=null){
          Node next = curr.next;
          curr.next = pre;
          pre = curr;
          curr = next;

      }
      return pre;
    }

    public static Node findMiddleNode(Node list){
        Node fast = list;
        Node slow = list;
        while(fast != null && fast.next !=  null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

