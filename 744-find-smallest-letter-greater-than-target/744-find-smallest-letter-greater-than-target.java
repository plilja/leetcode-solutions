class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int a = 0;
        int b = letters.length;
        while (a < b) {
            int m = (a + b) / 2;
            char c = letters[m];
            if (c <= target) {
                a = m + 1;
            } else {
                b = m;
            }
        }

        if (a < letters.length && letters[a] > target) {
            return letters[a];
        } else {
            return letters[0]; // no solution
        }
    }
}

