class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            for (int i = 0; i < m && current != null; ++i) {
                prev = current;
                current = current.next;
            }
            for (int i = 0; i < n && current != null; ++i) {
                current = current.next;
            }
            prev.next = current;
        }
        return head;
    }
}