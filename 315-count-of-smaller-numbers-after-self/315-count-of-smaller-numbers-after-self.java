class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        Bst root = new Bst(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; --i) {
            int v = nums[i];
            result.add(root.countSmaller(v));
            root = root.insert(v);
        }
        Collections.reverse(result);
        return result;
    }

    class Bst {
        Bst left;
        Bst right;
        int val;
        int size;

        public Bst(int val) {
            this.val = val;
            this.size = 1;
        }

        int countSmaller(int val) {
            if (val > this.val) {
                if (right == null) {
                    return size;
                } else {
                    return right.countSmaller(val) + 1 + getSize(left);
                }
            } else if (left != null) {
                return left.countSmaller(val);
            } else {
                return 0;
            }
        }

        private static int getSize(Bst bst) {
            if (bst == null) {
                return 0;
            } else {
                return bst.size;
            }
        }

        Bst insert(int val) {
            size++;
            if (val >= this.val) {
                if (right == null) {
                    right = new Bst(val);
                } else {
                    right = right.insert(val);
                }
            } else {
                if (left == null) {
                    left = new Bst(val);
                } else {
                    left = left.insert(val);
                }
            }
            if (getSize(left) > getSize(right) + 1) {
                Bst leftTmp = left;
                Bst tmp = leftTmp.right;
                leftTmp.right = this;
                left = tmp;
                size -= getSize(leftTmp);
                size += getSize(tmp);
                leftTmp.size += getSize(right) + 1;
                return leftTmp;
            } else if (getSize(right) > getSize(left) + 1) {
                Bst rightTmp = right;
                Bst tmp = rightTmp.left;
                rightTmp.left = this;
                right = tmp;
                size -= getSize(rightTmp);
                size += getSize(tmp);
                rightTmp.size += getSize(left) + 1;
                return rightTmp;
            } else {
                return this;
            }
        }
    }
}
