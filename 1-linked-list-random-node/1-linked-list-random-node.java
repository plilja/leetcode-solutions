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
    private final Random random = new Random();
    private final ListNode head;
    
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int size = getSize();
        int index = random.nextInt(size);
        return valueAt(index);
    }
    
    private int getSize() {
        ListNode current = head;
        int result = 0;
        while (current != null) {
            result++;
            current = current.next;
        }
        return result;
    }
    
    private int valueAt(int index) {
        ListNode current = head;
        int i = 0;
        while (i < index) {
            i++;
            current = current.next;
        }
        return current.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
