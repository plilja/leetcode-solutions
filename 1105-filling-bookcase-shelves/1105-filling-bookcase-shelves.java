/*
[1,1] [1, 100] [1, 100] [1, 1]
shelfWidth = 2
*/
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        // dp[i] == min height to shelf all books from i to end (all shelves are full)
        int[] dp = new int[books.length + 1];
        for (int i = books.length - 1; i >= 0; --i) {
            int height = books[i][1];
            int shelf = shelfWidth - books[i][0];
            dp[i] = height + dp[i + 1];
            int j = i;
            while (j + 1 < books.length && shelf - books[j + 1][0] >= 0) {
                j++;
                shelf -= books[j][0];
                height = Math.max(height, books[j][1]);
                dp[i] = Math.min(dp[i], height + dp[j + 1]);
            }
        }
        return dp[0];
    }
}