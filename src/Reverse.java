import java.util.List;

public class Reverse {
    //遍历
    public ListNode reverse(ListNode head){
      ListNode pre = null;
      ListNode cur = head;
      ListNode next = null;
      ListNode headNode = null;
      for (;cur!=null;){
          next = cur.next;
          if (next == null){
              headNode = cur;
          }
          cur.next = pre;
          pre = cur;
          cur = next;
      }
      return headNode;
    }
    //递归
    public ListNode reverse2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newNode = reverse2(next);
        next.next = head;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1);
        ListNode listNodeB = new ListNode(6);
        ListNode listNodeC = new ListNode(2);
        ListNode listNodeD = new ListNode(3);
        ListNode listNodeE = new ListNode(4);
        listNodeA.next = listNodeB;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeD;
        listNodeD.next = listNodeE;

        Reverse reverse = new Reverse();
        ListNode cur = reverse.reverse2(listNodeA);

        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
