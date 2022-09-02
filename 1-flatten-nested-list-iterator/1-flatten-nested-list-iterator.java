/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private final List<NestedInteger> nestedList;
    private int nestedListPointer = 0;
    private NestedIterator nestedIterator = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        stepToNext();
    }

    @Override
    public Integer next() {
        int result;
        NestedInteger nestedInteger = nestedList.get(nestedListPointer);
        if (nestedInteger.isInteger()) {
            result = nestedInteger.getInteger();
            nestedListPointer++;
        } else {
            result = nestedIterator.next();
        }
        stepToNext();
        return result;
    }
    
    private void stepToNext() {
        while (nestedListPointer < nestedList.size()) {
            NestedInteger current = nestedList.get(nestedListPointer);
            if (current.isInteger()) {
                break;
            }
            if (nestedIterator == null) {
                nestedIterator = new NestedIterator(current.getList());
            }
            if (nestedIterator.hasNext()) {
                break;
            }
            nestedListPointer++;
            nestedIterator = null;
        }
    }

    @Override
    public boolean hasNext() {
        return nestedListPointer < nestedList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
