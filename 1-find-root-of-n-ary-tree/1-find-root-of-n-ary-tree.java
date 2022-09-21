/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        Map<Node, Node> parent = new HashMap<>();
        for (Node node : tree) {
            for (Node child : node.children) {
                parent.put(child, node);
            }
        }
        for (Node node : tree) {
            if (!parent.containsKey(node)) {
                return node;
            }
        }
        return null;
    }
}
