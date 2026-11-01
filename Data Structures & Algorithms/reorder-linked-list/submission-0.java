class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // 1. Finding mid
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 2. Reversing from mid's next (Fixed)
        ListNode prev = null;       // Must be null so the new tail points to null
        ListNode curr = p1.next;    // Second half starts after p1
        p1.next = null;             // Sever the connection to split the lists cleanly

        while (curr != null) {      // Traverse all the way to the end
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // 3. Joining / Weaving elements alternately
        ListNode a = head;
        ListNode b = prev;          // 'prev' is the head of the reversed second half

        while (b != null) {
            ListNode temp1 = a.next;
            ListNode temp2 = b.next;

            a.next = b;
            b.next = temp1;

            a = temp1;
            b = temp2;
        }
    }
}