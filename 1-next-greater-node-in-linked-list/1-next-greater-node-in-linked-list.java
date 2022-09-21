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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; --i) {
            int value = list.get(i);
            while (!stack.isEmpty() && stack.peekLast() <= value) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peekLast();
            }
            stack.add(value);
        }
        return result;
    }
}
