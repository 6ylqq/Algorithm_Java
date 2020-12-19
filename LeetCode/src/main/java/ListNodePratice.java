import java.util.Stack;

/**
 * @author ylqq
 */
public class ListNodePratice {

    public static void main(String[] args) {
        ListNodePratice listNodePratice=new ListNodePratice();
        int[] test={1,2,2,1};
        ListNode head=null,cur=null;
        for (int i : test) {
            ListNode node=new ListNode(i);
            if (head==null){
                head=node;
                cur=head;
            }
            cur.next=node;
            cur=cur.next;
        }
        listNodePratice.isPalindrome(head);
    }

    /**
     * leetcode445 注意看到逆序优先想到用栈去解决
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> h1 = new Stack<>();
        Stack<ListNode> h2 = new Stack<>();
        while (l1 != null) {
            h1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            h2.add(l2);
            l2 = l2.next;
        }
        int upNum = 0;
        ListNode ans = null;
        while (!h1.isEmpty() || !h2.isEmpty() || upNum != 0) {
            int a = h1.isEmpty() ? 0 : h1.pop().val;
            int b = h2.isEmpty() ? 0 : h2.pop().val;
            int cur = a + b + upNum;
            upNum = cur / 10;
            cur %= 10;
            ListNode curNode = new ListNode(cur);
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }

    /**
     * leetcode328
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * leetcode234
     * 请判断一个链表是否为回文链表。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            ListNode temp=slow;
            slow=slow.next;
            temp.next=null;
        }
        if(fast==null){
            ListNode temp2=slow;
            slow=slow.next;
            temp2=null;
        }
        return isEqual(head,reverseList(slow));
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            //保存号cur.next，以防指针丢失
            next = cur.next;
            //反转cur.next这个指针，使其指向前一个
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private boolean isEqual(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }
}
