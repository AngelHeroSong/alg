import java.util.List;
import java.util.Objects;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1!=null&&l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1==null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listA1 = new ListNode(0);
        ListNode listA2 = new ListNode(1);
        ListNode listA3 = new ListNode(4);
        ListNode listA4 = new ListNode(9);
        ListNode listA5 = new ListNode(10);

        listA1.next = listA2;
        listA2.next = listA3;
        listA3.next = listA4;
        listA4.next = listA5;

        ListNode listB1 = new ListNode(1);
        ListNode listB2 = new ListNode(3);
        ListNode listB3 = new ListNode(5);
        ListNode listB4 = new ListNode(8);
        ListNode listB5 = new ListNode(10);

        listB1.next = listB2;
        listB2.next = listB3;
        listB3.next = listB4;
        listB4.next = listB5;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(listA1,listB1);
       while (listNode!=null){
           System.out.println(listNode.val);
           listNode = listNode.next;
       }


    }
}
   class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
