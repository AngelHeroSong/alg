import java.util.List;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        ListNode cur2 = new ListNode(0);
        cur2.next = head;

        int len = 0 ;
        while(cur!=null){
            len++;
            cur = cur.next;
        }

        cur = cur2;
        int index = 0;
        while(cur!=null){
            if (index == len-n){
                if (cur.next.next==null){
                    cur.next = null;
                }else{
                    cur.next = cur.next.next;
                }
                break;
            }
            cur =cur.next;
            index++;
        }
        return cur2.next;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1);
       /* ListNode listNodeB = new ListNode(6);
        ListNode listNodeC = new ListNode(2);
        ListNode listNodeD = new ListNode(3);
        ListNode listNodeE = new ListNode(4);
        listNodeA.next = listNodeB;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeD;
        listNodeD.next = listNodeE;*/
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
       ListNode cur = removeNthFromEnd.removeNthFromEnd(listNodeA,2);

        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
