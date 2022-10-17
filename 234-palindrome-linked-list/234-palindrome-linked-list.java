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
    public boolean isPalindrome(ListNode head) {
        Map<Integer, ListNode> indexToNode = new HashMap<>();
        int index = 0;
        ListNode current = head;
        while (current != null) {
            indexToNode.put(index, current);
            index++;
            current = current.next;
        }
        for (int i = 0; i < index / 2; ++i) {
            if (indexToNode.get(i).val != indexToNode.get(index - 1 - i).val) {
                return false;
            }
        }
        return true;
    }
}

