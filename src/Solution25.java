public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        for (ListNode p = dummy; ; ) {
            ListNode q = p;
            for (int i = 0; i < k && q != null; i++) q = q.next;
            if (q == null) break;
            ListNode a = p.next, b = a.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = b.next;
                b.next = a;
                a = b;
                b = next;
            }
            ListNode next = p.next;
            p.next = a;
            next.next = b;
            p = next;
        }
        return dummy.next;
    }
}