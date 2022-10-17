/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList, 1);
        List<Integer> values = new ArrayList<>();
        getValues(nestedList, values, maxDepth, 1);
        int result = 0;
        for (int w : values) {
            result += w;
        }
        return result;
    }
    
    private int getMaxDepth(List<NestedInteger> nestedList, int currentDepth) {
        int result = nestedList.isEmpty() ? 1 : currentDepth;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result = Math.max(result, currentDepth);
            } else {
                int sub = getMaxDepth(ni.getList(), currentDepth + 1);
                result = Math.max(result, sub);
            }
        }
        return result;
    }
    
    private void getValues(List<NestedInteger> nestedList, List<Integer> result, int maxDepth, int currentDepth) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result.add(ni.getInteger() * (maxDepth - currentDepth + 1));
            } else {
                getValues(ni.getList(), result, maxDepth, currentDepth + 1);
            }
        }
    }
}