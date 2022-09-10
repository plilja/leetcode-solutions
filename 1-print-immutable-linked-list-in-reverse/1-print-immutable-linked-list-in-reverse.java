/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Deque<ImmutableListNode> stack = new ArrayDeque<>();
        ImmutableListNode current = head;
        while (current != null) {
            stack.add(current);
            current = current.getNext();
        }
        while (!stack.isEmpty()) {
            var node = stack.pollLast();
            node.printValue();
        }
    }
}
