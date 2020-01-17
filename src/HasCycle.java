import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head!=null){
            if (set.contains(head)){
                return true;
            }else{
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode listNodeA = new ListNode(1);
        ListNode listNodeB = new ListNode(6);
        ListNode listNodeC = new ListNode(2);
        ListNode listNodeD = new ListNode(3);
        ListNode listNodeE = new ListNode(4);
        listNodeA.next = listNodeB;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeD;
        //listNodeD.next = listNodeA;
        System.out.println(hasCycle.hasCycle(listNodeA));

    }
}
