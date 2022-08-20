class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var ransomNoteCharCounts = charCounts(ransomNote);
        var magazineCharCounts = charCounts(magazine);
        for (int i = 0; i < ransomNoteCharCounts.length; ++i) {
            if (ransomNoteCharCounts[i] > magazineCharCounts[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] charCounts(String str) {
        int[] result = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            result[(int) (c - 'a')]++;
        }
        return result;
    }
}
