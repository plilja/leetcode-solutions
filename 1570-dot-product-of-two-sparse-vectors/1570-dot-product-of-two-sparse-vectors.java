class SparseVector {
    private final List<Integer> elementValues = new ArrayList<>();
    private final List<Integer> elementIndexes = new ArrayList<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                elementValues.add(nums[i]);
                elementIndexes.add(i);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < elementValues.size() && j < vec.elementValues.size()) {
            int iIdx = elementIndexes.get(i);
            int jIdx = vec.elementIndexes.get(j);
            if (iIdx == jIdx) {
                result += elementValues.get(i) * vec.elementValues.get(j);
                i++;
                j++;
            } else if (iIdx < jIdx) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);