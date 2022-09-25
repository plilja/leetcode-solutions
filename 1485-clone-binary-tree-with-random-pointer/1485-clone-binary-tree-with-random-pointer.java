/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */
class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> nodeMap = new HashMap<>();
        NodeCopy rootCopy = copyStructure(root, nodeMap);
        assignRandomPointers(root, rootCopy, nodeMap);
        return rootCopy;
    }
    
    private NodeCopy copyStructure(Node node, Map<Node, NodeCopy> nodeMap) {
        if (node == null) {
            return null;
        } else {
            NodeCopy result = new NodeCopy(node.val);
            nodeMap.put(node, result);
            result.left = copyStructure(node.left, nodeMap);
            result.right = copyStructure(node.right, nodeMap);
            return result;
        }
    }
    
    private void assignRandomPointers(Node root, NodeCopy rootCopy, Map<Node, NodeCopy> nodeMap) {
        if (root != null) {
            if (root.random != null) {
                rootCopy.random = nodeMap.get(root.random);
            }
            assignRandomPointers(root.left, rootCopy.left, nodeMap);
            assignRandomPointers(root.right, rootCopy.right, nodeMap);
            
        }
    }
}