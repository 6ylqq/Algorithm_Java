/**
 * @author ylqq
 */
public class ReverseList {
    /**
     * 反转链表
     * */
    public ListNode reverseList(ListNode head){
        ListNode pre=null,cur=head,next=null;
        while (cur!=null){
            //保存号cur.next，以防指针丢失
            next=cur.next;

            //反转cur.next这个指针，使其指向前一个
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    /**
     * 递归反转链表
     */
    public ListNode recursionReverseList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode node=recursionReverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
