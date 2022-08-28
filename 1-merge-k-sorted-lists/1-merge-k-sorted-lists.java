/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode resultCurrent = null;
        while (true) {
            int minIdx = -1;
            for (int i = 0; i < lists.length; ++i) {
                ListNode node = lists[i];
                if (node != null) {
                    if (minIdx == -1 || lists[minIdx].val > node.val) {
                        minIdx = i;
                    }
                }
            }
            if (minIdx == -1) {
                break;
            }
            if (result == null) {
                result = lists[minIdx];
                resultCurrent = lists[minIdx];
            } else {
                resultCurrent.next = lists[minIdx];
                resultCurrent = resultCurrent.next;
            }
            lists[minIdx] = lists[minIdx].next;
        }
        return result;
    }
}
