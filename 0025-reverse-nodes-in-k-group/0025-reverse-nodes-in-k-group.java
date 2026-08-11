class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // head is now the last node of this reversed group
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this group
        return prev;
    }
}