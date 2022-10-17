/*


6 100 70 60 40 20 30 40 10 80 90 0
1   5  4  3  2  1  2  3  1  2  3 1

[1,3,2,2,1]

1  2 1 2 1

*/
class Solution {
    public int candy(int[] ratings) {
        int[] rightSmaller = new int[ratings.length];
        int rightCount = 0;
        for (int i = ratings.length - 2; i >= 0; --i) {
            int r = ratings[i];
            if (ratings[i + 1] < r) {
                rightCount++;
            } else {
                rightCount = 0;
            }
            rightSmaller[i] = rightCount;
        }
        int[] leftSmaller = new int[ratings.length];
        int leftCount = 0;
        for (int i = 1; i < ratings.length; ++i) {
            int r = ratings[i];
            if (ratings[i - 1] < r) {
                leftCount++;
            } else {
                leftCount = 0;
            }
            leftSmaller[i] = leftCount;
        }
        
        int result = 0;
        for (int i = 0; i < ratings.length; ++i) {
            result += Math.max(leftSmaller[i], rightSmaller[i]) + 1;
        }
        return result;
    }
}
