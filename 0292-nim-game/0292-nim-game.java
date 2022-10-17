/*

1-3 => winner
4 => looser
5 => winner
6 => winner
7 => winner
8 => looser
9 => winner
10 => winner
11 => winner
12 => looser
*/
class Solution {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
        
    }
}
