/*
0 -> yes (but cannot be at start, so 10 doesn't work)
1 -> yes
2 -> not valid
3 -> not valid
4 -> not valid
5 -> not valid
6 -> converts to 9
7 -> not valid
8 -> yes
9 -> converts to 6

Examples:
69
96
101
609
818
*/
class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder upsideDown = new StringBuilder();
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            switch (c) {
                case '2':
                case '3':
                case '4':
                case '5':
                case '7':
                    return false;
                case '0':
                case '1':
                case '8':
                    upsideDown.append(c);
                    break;
                case '6':
                    upsideDown.append('9');
                    break;
                case '9':
                    upsideDown.append('6');
                    break;
            }
        }
        upsideDown.reverse();
        return num.equals(upsideDown.toString());
    }
}