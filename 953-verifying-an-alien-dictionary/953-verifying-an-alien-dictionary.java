class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if (!isLessOrEqual(words[i], words[j], order)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isLessOrEqual(String a, String b, String order) {
        for (int i = 0; i < a.length(); ++i) {
            if (i >= b.length()) {
                return false;
            }
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            int caIdx = order.indexOf(ca);
            int cbIdx = order.indexOf(cb);
            if (cbIdx < caIdx) {
                return false;
            }
            if (caIdx < cbIdx) {
                return true;
            }
        }
        return true;
    }
}
