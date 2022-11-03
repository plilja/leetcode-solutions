class Solution {
    public int calculateTime(String keyboard, String word) {
        int finger = 0;
        int result = 0;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            int index = keyboard.indexOf(c);
            result += Math.abs(finger - index);
            finger = index;
        }
        return result;
    }
}