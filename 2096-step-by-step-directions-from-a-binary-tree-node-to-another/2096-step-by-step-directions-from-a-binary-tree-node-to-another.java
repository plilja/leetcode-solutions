/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String directionsStart = getDirectionsSingle(root, startValue);
        String directionsDest = getDirectionsSingle(root, destValue);
        int i = 0;
        while (i < directionsStart.length() && 
               i < directionsDest.length() &&
               directionsStart.charAt(i) == directionsDest.charAt(i)) {
            i++;
        }
        StringBuilder result = new StringBuilder();
        for (int j = i; j < directionsStart.length(); ++j) {
            result.append("U");
        }
        for (int j = i; j < directionsDest.length(); ++j) {
            result.append(directionsDest.charAt(j));
        }
        return result.toString();
    }
    
    private String getDirectionsSingle(TreeNode node, int destValue) {
        StringBuilder result = new StringBuilder();
        getDirectionsSingle(node, destValue, result);
        result.reverse();
        return result.toString();
    }
        
    private boolean getDirectionsSingle(TreeNode node, int destValue, StringBuilder result) {
        if (node == null) {
            return false;
        } else {
            if (node.val == destValue) {
                return true;
            } else {
                if (getDirectionsSingle(node.left, destValue, result)) {
                    result.append("L");
                    return true;
                }
                if (getDirectionsSingle(node.right, destValue, result)) {
                    result.append("R");
                    return true;
                }
                return false;
            }
        }
    }
}