// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer peeked = null;
    private boolean hasPeeked = false;
    
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (hasPeeked) {
            return peeked;
        } else {
            peeked = iterator.next();
            hasPeeked = true;
            return peeked;
        }
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (hasPeeked) {
            Integer result = peeked;
            peeked = null;
            hasPeeked = false;
            return result;
        } else {
            return iterator.next();
        }
	    
	}
	
	@Override
	public boolean hasNext() {
	    if (hasPeeked) {
            return true;
        } else {
            return iterator.hasNext();
        }
	}
}