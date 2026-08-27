class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);

            // Fewer than k nodes remain.
            if (kth == null) break;

            ListNode groupNext = kth.next;

            // Reverse the current group.
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;

            while (cur != groupNext) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode start, int k) {
        ListNode cur = start;

        for (int i = 0; i < k; i++) {
            cur = cur.next;
            if (cur == null) return null;
        }

        return cur;
    }
}
