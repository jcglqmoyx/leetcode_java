public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy;
        while (head != null) {
            while (head != null && head.val == p.next.val) head = head.next;
            p = p.next;
            p.next = head;
        }
        return dummy.next;
    }
}
