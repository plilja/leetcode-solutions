/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long a = 1;
        long b = n;
        while (a < b) {
            long middle = (a + b) / 2;
            int ans = guess((int)middle);
            if (ans == 0) {
                return (int)middle;
            } else if (ans == 1) {
                a = middle + 1;
            } else {
                b = middle - 1;
            }
            
        }
        return (int)a;
    }
}