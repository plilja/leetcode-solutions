/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraphHelper(node, new HashMap<>());
    }
    
    private Node cloneGraphHelper(Node node, Map<Node, Node> oldToNew) {
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        } else {
            Node result = new Node(node.val);
            oldToNew.put(node, result);
            for (Node neighbour : node.neighbors) {
                Node newNode = cloneGraphHelper(neighbour, oldToNew);
                result.neighbors.add(newNode);
            }
            return result;
        }
        
    }
}
