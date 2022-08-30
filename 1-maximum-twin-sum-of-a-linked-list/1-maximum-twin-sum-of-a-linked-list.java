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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        Map<Integer, ListNode> nodes = new HashMap<>();
        int i = 0;
        while (curr != null) {
            nodes.put(i, curr);
            i++;
            curr = curr.next;
        }
        int result = -1;
        for (int j = 0; j < i / 2; ++j) {
            ListNode node1 = nodes.get(j);
            ListNode node2 = nodes.get(i - j - 1);
            result = Math.max(result, node1.val + node2.val);
        }
        return result;
    }
}
